<?php

namespace Transito\MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Transito\RESTBundle\Entity\State;
use \Doctrine\Common\Collections\ArrayCollection;
use Transito\RESTBundle\Entity\Procedure;

class ProcedureController extends Controller {

    /**
     *
     * @var ArrayCollection<Procedure>
     */
    private $restProcedureEntity;

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
        return $this->render('TransitoMainBundle:Admin:procedures.html.twig', [
                    'form' => $form->createView(),
                    'errors' => $errors,
                    'procedures' => $procedures
        ]);
    }

}
