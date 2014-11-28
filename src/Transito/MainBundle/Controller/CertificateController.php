<?php

namespace Transito\MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use \Doctrine\Common\Collections\ArrayCollection;
use Transito\RESTBundle\Entity\Procedure;
use Transito\RESTBundle\Entity\Exam;
use Transito\RESTBundle\Entity\State;

class CertificateController extends Controller {

    /**
     *
     * @var Exam
     */
    private $restExamEntity;

    /**
     *
     * @var ArrayCollection<Procedure>
     */
    private $restProcedureEntity;

    public function validateAction(Request $request, $bill) {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged())
            return $this->redirect($this->generateUrl('login_page'));

        $query = [
            'token' => $loginManager->getUser()->getToken(),
            'bill' => $bill
        ];

        try {
            $user = $this->get('rest')->getEntity('/user/get', 'Transito\RESTBundle\Entity\User', $query);
        } catch (\RuntimeException $exc) {
            return $this->render('TransitoMainBundle:Admin:500.html.twig');
        }

        $exams = [];

        foreach (['speech_therapy', 'psychological', 'physical', 'optometry'] as $type) {

            // obtain the above stored test
            $query = [
                'token' => $loginManager->getUser()->getToken(),
                'type' => $type,
                'bill' => $bill
            ];

            try {
                $this->restExamEntity = $this->get('rest')->getEntity('/exam/get', 'Transito\RESTBundle\Entity\Exam', $query);
            } catch (\RuntimeException $exc) {
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
            }

            $exams[$type] = $this->restExamEntity;
        }


        // make validation form
        $form = $this->createFormBuilder()
                ->add('result', 'choice', [
                    'choices' => [0 => 'Rechazado', 1 => 'Aprobado'],
                ])
                ->getForm();

        // If form send
        if ($request->isMethod('POST')) {
            $form->handleRequest($request);

            // If form not is valid
            if ($form->isValid()) {

                $data = $form->getData();

                $certificate = new \Transito\MainBundle\Validations\Certificate();

                $certificate->setResult($data['result']);

                // Validate fields
                $validator = $this->get('validator');
                $errors = $validator->validate($certificate);

                // If errors in fields
                if (count($errors) > 0)
                    return $this->showValidateForm($form, $bill, $exams, $user, $errors);

                // prepare parameters

                $query = [
                    'token' => $loginManager->getUser()->getToken()
                ];

                $post = [
                    'result' => $certificate->getResult()
                ];

                // send result
                try {
                    $state = $this->get('rest')->postEntity(
                            '/certificate', $post, 'Transito\RESTBundle\Entity\State', $query
                    );
                } catch (\RuntimeException $exc) {
                    return $this->render('TransitoMainBundle:Admin:500.html.twig');
                }

                // redirect to procedures
                if ($state->getStatus() == State::SUCCESS)
                    return $this->redirect(
                                    $this->generateUrl(
                                            'certificate_list_page'
                                    )
                    );
                else
                    return $this->render('TransitoMainBundle:Admin:500.html.twig');
            }
        }

        return $this->showValidateForm($form, $bill, $exams, $user);
    }

    private function showValidateForm($form, $bill, $exams, $user, $errors = []) {
        return $this->render('TransitoMainBundle:Admin:validate.html.twig', [
                    'form' => $form->createView(),
                    'bill' => $bill,
                    'errors' => $errors,
                    'user' => $user,
                    'exams' => $exams
        ]);
    }

    public function indexAction(Request $request) {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged())
            return $this->redirect($this->generateUrl('login_page'));

        // Else make pau form
        $form = $this->createFormBuilder()
                ->add('date', 'text')
                ->add('dni', 'text')
                ->add('name', 'text')
                ->getForm();

        // If form send
        if ($request->isMethod('POST')) {
            $form->handleRequest($request);

            // If form not is valid
            if ($form->isValid()) {

                $data = $form->getData();

                $procedure = new \Transito\MainBundle\Validations\Procedure();

                $procedure->setDate($data['date']);
                $procedure->setDni($data['dni']);
                $procedure->setName($data['name']);

                // Validate fields
                $validator = $this->get('validator');
                $errors = $validator->validate($procedure);

                // If errors in fields
                if (count($errors) > 0)
                    return $this->showRecordForm($form, $errors, $this->restProcedureEntity);

                // prepare parameters

                $query = [
                    'token' => $loginManager->getUser()->getToken()
                ];

                $post = [
                    'date' => $procedure->getDate(),
                    'dni' => $procedure->getDni(),
                    'name' => $procedure->getName()
                ];

                // send pau
                try {
                    $this->restProcedureEntity = $this->get('rest')->postEntity(
                            '/procedures', $post, 'ArrayCollection<Transito\RESTBundle\Entity\Procedure>', $query
                    );
                } catch (\RuntimeException $exc) {
                    return $this->render('TransitoMainBundle:Admin:500.html.twig');
                }
            }
        } else {

            $query = [
                'token' => $loginManager->getUser()->getToken()
            ];

            try {
                $this->restProcedureEntity = $this->get('rest')->postEntity('/procedures', [], 'ArrayCollection<Transito\RESTBundle\Entity\Procedure>', $query);
            } catch (\RuntimeException $exc) {
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
            }
        }

        return $this->showRecordForm($form, [], $this->restProcedureEntity);
    }

    private function showRecordForm($form, $errors = [], $procedures) {
        return $this->render('TransitoMainBundle:Admin:certificates.html.twig', [
                    'form' => $form->createView(),
                    'errors' => $errors,
                    'procedures' => $procedures
        ]);
    }

}
