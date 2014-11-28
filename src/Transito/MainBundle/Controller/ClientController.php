<?php

namespace Transito\MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Transito\EntityBundle\User;
use Symfony\Component\HttpFoundation\Request;
use Transito\RESTBundle\Entity\Client;

class ClientController extends Controller {

    /**
     *
     * @var Client
     */
    private $restSingleClientEntity;

    public function managerAction(Request $request, $pau) {

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
        $form = $this->createFormBuilder()
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
                ->add('payment', 'text')
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

            $client = new \Transito\MainBundle\Validations\Client();
            $client->setDni($data['dni']);
            $client->setFirstName($data['firstName']);
            $client->setLastName($data['lastName']);
            $client->setFirstSurname($data['firstSurname']);
            $client->setLastSurname($data['lastSurname']);
            $client->setBirthday($data['birthday']);
            $client->setLocation($data['location']);
            $client->setPhone($data['phone']);
            $client->setCellphone($data['cellphone']);
            $client->setEmail($data['email']);
            $client->setPayment($data['payment']);

            // Validate fields
            $validator = $this->get('validator');
            $errors = $validator->validate($client);

            // If errors in fields
            if (count($errors) > 0)
                return $this->showManagerForm($form, $errors, $this->restSinglePauEntity);

            // prepare parameters

            $query = [
                'token' => $loginManager->getUser()->getToken()
            ];

            $post = [
                'dni' => $client->getDni(),
                'firstName' => $client->getFirstName(),
                'lastName' => $client->getLastName(),
                'firstSurname' => $client->getFirstSurname(),
                'lastSurname' => $client->getLastSurname(),
                'birthday' => $client->getBirthday(),
                'location' => $client->getLocation(),
                'phone' => $client->getPhone(),
                'cellphone' => $client->getCellphone(),
                'email' => $client->getEmail(),
                'payment' => $client->getPayment()
            ];

            // send pau
            try {
                $this->restSingleClientEntity = $this->get('rest')->postEntity(
                        '/user/new', $post, 'Transito\RESTBundle\Entity\Client', $query
                );
            } catch (\RuntimeException $exc) {
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
            }

            // redirect to bill
            if ($this->restSingleClientEntity->getStatus() == Client::SUCCESS)
                return $this->redirect(
                                $this->generateUrl(
                                        'user_bill_page', [
                                    'bill' => $this->restSingleClientEntity->getBill()
                                        ]
                                )
                );
            else
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
        } while (FALSE);


        // Show pau form
        return $this->showManagerForm($form, [], $this->restSinglePauEntity);
    }

    private function showManagerForm($form, $errors = [], $pau = null) {
        return $this->render('TransitoMainBundle:Admin:client_manager.html.twig', [
                    'form' => $form->createView(),
                    'errors' => $errors,
                    'pau' => $pau
        ]);
    }

}
