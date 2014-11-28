<?php

namespace Transito\MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Transito\EntityBundle\User;
use Symfony\Component\HttpFoundation\Request;
use Transito\RESTBundle\Entity\State;
use \Doctrine\Common\Collections\ArrayCollection;
use Transito\RESTBundle\Entity\Pau;
use Transito\RESTBundle\Entity\Doctor;
use Transito\RESTBundle\Entity\Record;

class PauController extends Controller {

    /**
     *
     * @var ArrayCollection<Pau>
     */
    private $restPauEntity;

    /**
     *
     * @var Pau
     */
    private $restSinglePauEntity;

    /**
     *
     * @var Record
     */
    private $restSingleRecordEntity;

    /**
     *
     * @var ArrayCollection<Doctor>
     */
    private $restDoctorEntity;

    /**
     *
     * @var ArrayCollection<Doctor>
     */
    private $restOfficialEntity;

    public function listAction() {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged() or $loginManager->getUser()->getRole() != User::SECRETARY)
            return $this->redirect($this->generateUrl('login_page'));

        $query = [
            'token' => $loginManager->getUser()->getToken()
        ];

        try {
            $this->restPauEntity = $this->get('rest')->getEntity('/paus', 'ArrayCollection<Transito\RESTBundle\Entity\Pau>', $query);
        } catch (\RuntimeException $exc) {
            return $this->render('TransitoMainBundle:Admin:500.html.twig');
        }

        return $this->render('TransitoMainBundle:Admin:pau.html.twig', [
                    'paus' => $this->restPauEntity
        ]);
    }

    public function doctorsAction($pau) {

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
            $this->restDoctorEntity = $this->get('rest')->getEntity('/doctors', 'ArrayCollection<Transito\RESTBundle\Entity\Doctor>', $query);
            $this->restOfficialEntity = $this->get('rest')->getEntity('/officials', 'ArrayCollection<Transito\RESTBundle\Entity\Doctor>', $query);
        } catch (\RuntimeException $exc) {
            return $this->render('TransitoMainBundle:Admin:500.html.twig');
        }

        return $this->render('TransitoMainBundle:Admin:doctors.html.twig', [
                    'pau' => $this->restSinglePauEntity,
                    'doctors' => $this->restDoctorEntity,
                    'officials' => $this->restOfficialEntity
        ]);
    }

    public function managerAction(Request $request, $pauID) {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged() or $loginManager->getUser()->getRole() != User::SECRETARY)
            return $this->redirect($this->generateUrl('login_page'));

        if ($pauID !== null) {
            $query = [
                'token' => $loginManager->getUser()->getToken(),
                'pau' => $pauID
            ];

            try {
                $this->restSinglePauEntity = $this->get('rest')->getEntity('/pau', 'Transito\RESTBundle\Entity\Pau', $query);
            } catch (\RuntimeException $exc) {
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
            }
        } else
            $this->restSinglePauEntity = null;

        // Else make pau form
        $form = $this->createFormBuilder()
                ->add('name', 'text')
                ->add('location', 'text')
                ->add('email', 'text')
                ->add('operation', 'text')
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

            $pau = new \Transito\MainBundle\Validations\Pau();
            $pau->setName($data['name']);
            $pau->setLocation($data['location']);
            $pau->setEmail($data['email']);
            $pau->setOperation($data['operation']);

            // Validate fields
            $validator = $this->get('validator');
            $errors = $validator->validate($pau);

            // If errors in fields
            if (count($errors) > 0)
                return $this->showManagerForm($form, $errors, $this->restSinglePauEntity);

            // prepare parameters

            $query = [
                'token' => $loginManager->getUser()->getToken()
            ];

            $post = [
                'name' => $pau->getName(),
                'location' => $pau->getLocation(),
                'email' => $pau->getEmail(),
                'operation' => $pau->getOperation()
            ];

            // send pau
            try {
                $action = ($pauID !== null) ? '/pau/edit' : '/pau/new';

                $state = $this->get('rest')->postEntity(
                        $action, $post, 'Transito\RESTBundle\Entity\State', $query
                );
            } catch (\RuntimeException $exc) {
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
            }

            // return to pau list page
            if ($state->getStatus() == State::SUCCESS)
                return $this->redirect($this->generateUrl('pau_list_page'));
            else
                return $this->showManagerForm(
                                $form, $this->get('utils')->createErrorsMessageArray(
                                        'El servidor rechazo su solicitud. Inténtalo de nuevo más tarde'
                                ), [], $this->restSinglePauEntity
                );
        } while (FALSE);


        // Show pau form
        return $this->showManagerForm($form, [], $this->restSinglePauEntity);
    }

    private function showManagerForm($form, $errors = [], $pau = null) {
        return $this->render('TransitoMainBundle:Admin:pau_manager.html.twig', [
                    'form' => $form->createView(),
                    'errors' => $errors,
                    'pau' => $pau
        ]);
    }

    public function recordsAction(Request $request) {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged() or $loginManager->getUser()->getRole() != User::SECRETARY)
            return $this->redirect($this->generateUrl('login_page'));

        $query = [
            'token' => $loginManager->getUser()->getToken()
        ];

        try {
            $this->restPauEntity = $this->get('rest')->getEntity('/paus', 'ArrayCollection<Transito\RESTBundle\Entity\Pau>', $query);
        } catch (\RuntimeException $exc) {
            return $this->render('TransitoMainBundle:Admin:500.html.twig');
        }

        $paus = [];

        foreach ($this->restPauEntity as $tmp)
            $paus[$tmp->getId()] = $tmp->getName();

        // Else make pau form
        $form = $this->createFormBuilder()
                ->add('paus', 'choice', [
                    'choices' => $paus
                ])
                ->add('firstDate', 'text')
                ->add('lastDate', 'text')
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

            $record = new \Transito\MainBundle\Validations\Record();

            $record->setPaus($data['paus']);
            $record->setFirstDate($data['firstDate']);
            $record->setLastDate($data['lastDate']);

            // Validate fields
            $validator = $this->get('validator');
            $errors = $validator->validate($record);

            // If errors in fields
            if (count($errors) > 0)
                return $this->showRecordForm($form, $errors, $this->restSinglePauEntity);

            // prepare parameters

            $query = [
                'token' => $loginManager->getUser()->getToken()
            ];

            $post = [
                'pau' => $record->getPaus(),
                'firstDate' => $record->getFirstDate(),
                'lastDate' => $record->getLastDate()
            ];

            // send pau
            try {
                $this->restSingleRecordEntity = $this->get('rest')->postEntity(
                        '/records', $post, 'Transito\RESTBundle\Entity\Record', $query
                );
            } catch (\RuntimeException $exc) {
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
            }

            // return to pau list page
            if ($this->restSingleRecordEntity->getStatus() == State::SUCCESS)
                return $this->showRecordForm($form, [], $this->restSinglePauEntity, $this->restSingleRecordEntity);
            else
                return $this->showRecordForm(
                                $form, $this->get('utils')->createErrorsMessageArray(
                                        'El servidor rechazo su solicitud. Inténtalo de nuevo más tarde'
                                ), [], $this->restSinglePauEntity
                );
        } while (FALSE);

        return $this->showRecordForm($form, [], $this->restSinglePauEntity);
    }

    private function showRecordForm($form, $errors = [], $pau = null, $report = null) {
        return $this->render('TransitoMainBundle:Admin:pau_records.html.twig', [
                    'form' => $form->createView(),
                    'errors' => $errors,
                    'pau' => $pau,
                    'report' => $report
        ]);
    }

}
