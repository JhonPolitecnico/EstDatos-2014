<?php

namespace Transito\MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Transito\EntityBundle\User;

class MainController extends Controller {

    public function indexAction() {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged())
            return $this->redirect($this->generateUrl('login_page'));


        var_dump($loginManager->getUser()->getRole());

        if ($loginManager->getUser()->getRole() == User::DOCTOR)
            return $this->redirect($this->generateUrl('procedure_list_page'));

        if ($loginManager->getUser()->getRole() == User::FUNCTIONARY)
            return $this->redirect($this->generateUrl('certificate_list_page'));

        if ($loginManager->getUser()->getRole() == User::SECRETARY)
            return $this->redirect($this->generateUrl('pau_list_page'));
    }

}
