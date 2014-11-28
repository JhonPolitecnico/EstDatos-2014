<?php

namespace Transito\MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Transito\EntityBundle\User;
use Symfony\Component\HttpFoundation\Request;
use Transito\RESTBundle\Entity\Doctor;
use Transito\RESTBundle\Entity\Pau;
use Transito\RESTBundle\Entity\State;

class WorkerController extends Controller {

    /**
     *
     * @var Doctor
     */
    private $restSingleWorkerEntity;

    /**
     *
     * @var Pau
     */
    private $restSinglePauEntity;

    /**
     *
     * @var State
     */
    private $restStateEntity;

    public function detailsAction($worker) {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged() or $loginManager->getUser()->getRole() != User::SECRETARY)
            return $this->redirect($this->generateUrl('login_page'));

        $query = [
            'token' => $loginManager->getUser()->getToken(),
            'worker' => $worker
        ];

        $this->restSingleWorkerEntity = $this->get('rest')->getEntity('/worker', 'Transito\RESTBundle\Entity\Doctor', $query);

        return $this->render('TransitoMainBundle:Admin:worker.html.twig', [
                    'worker' => $this->restSingleWorkerEntity
        ]);
    }

    public function managerAction(Request $request, $type, $pau) {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged() or $loginManager->getUser()->getRole() != User::SECRETARY)
            return $this->redirect($this->generateUrl('login_page'));


        $query = [
            'token' => $loginManager->getUser()->getToken(),
            'pau' => $pau
        ];

        try {
            $this->restSinglePauEntity = $this->get('rest')->getEntity('/pau', 'Transito\RESTBundle\Entity\Pau', $query);
        } catch (\RuntimeException $exc) {
            return $this->render('TransitoMainBundle:Admin:500.html.twig');
        }

        // Else make pau form
        $form = $this->createFormBuilder(null, [
                    'validation_groups' => ['workExperience']
                ])
                ->add('dni', 'text')
                ->add('firstName', 'text')
                ->add('lastName', 'text')
                ->add('firstSurname', 'text')
                ->add('lastSurname', 'text')
                ->add('birthday', 'text')
                ->add('location', 'text')
                ->add('phone', 'text')
                ->add('cellphone', 'text')
                ->add('email', 'text')
                ->add('workExperience', 'collection', [
                    'type' => new \Transito\MainBundle\Form\Type\WorkExperienceType(),
                    'allow_add' => true,
                    'allow_delete' => true,
                        ]
                )
                ->getForm();

        do {
            // If form send
            if (!$request->isMethod('POST'))
                break;

            $form->handleRequest($request);

            // If form not is valid
            if (!$form->isValid())
                break;

            $data = $form->getData();

            $worker = new \Transito\MainBundle\Validations\Doctor();
            $worker->setDni($data['dni']);
            $worker->setFirstName($data['firstName']);
            $worker->setLastName($data['lastName']);
            $worker->setFirstSurname($data['firstSurname']);
            $worker->setLastSurname($data['lastSurname']);
            $worker->setBirthday($data['birthday']);
            $worker->setLocation($data['location']);
            $worker->setPhone($data['phone']);
            $worker->setCellphone($data['cellphone']);
            $worker->setEmail($data['email']);
            $worker->setWorkExperience($data['workExperience']);

            // Validate fields
            $validator = $this->get('validator');
            $errors = $validator->validate($worker);

            // If errors in fields
            if (count($errors) > 0)
                return $this->showManagerForm($form, $type, $errors, $this->restSinglePauEntity);

            // prepare parameters

            $query = [
                'token' => $loginManager->getUser()->getToken()
            ];

            $post = [
                'type' => $type,
                'pau' => $pau,
                'dni' => $worker->getDni(),
                'firstName' => $worker->getFirstName(),
                'lastName' => $worker->getLastName(),
                'firstSurname' => $worker->getFirstSurname(),
                'lastSurname' => $worker->getLastSurname(),
                'birthday' => $worker->getBirthday(),
                'location' => $worker->getLocation(),
                'phone' => $worker->getPhone(),
                'cellphone' => $worker->getCellphone(),
                'email' => $worker->getEmail(),
                'workExperience' => $worker->getWorkExperience()
            ];

            // send pau
            try {
                $this->restStateEntity = $this->get('rest')->postEntity(
                        '/worker/new', $post, 'Transito\RESTBundle\Entity\State', $query
                );
            } catch (\RuntimeException $exc) {
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
            }

            // redirect to bill
            if ($this->restStateEntity->getStatus() == State::SUCCESS)
                return $this->redirect(
                                $this->generateUrl(
                                        'pau_doctors_list_page', [
                                    'pau' => $this->restSinglePauEntity->getId()
                                        ]
                                )
                );
            else
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
        } while (FALSE);


        // Show pau form
        return $this->showManagerForm($form, $type, [], $this->restSinglePauEntity);
    }

    private function showManagerForm($form, $type, $errors = [], $pau = null) {
        return $this->render('TransitoMainBundle:Admin:worker_manager.html.twig', [
                    'form' => $form->createView(),
                    'type' => $type,
                    'errors' => $errors,
                    'pau' => $pau
        ]);
    }

}
