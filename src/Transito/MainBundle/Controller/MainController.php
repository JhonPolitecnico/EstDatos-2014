<?php

namespace Transito\MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class MainController extends Controller {

    public function indexAction() {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged())
            return $this->redirect($this->generateUrl('login_page'));

        return $this->render('TransitoMainBundle:Admin:main.html.twig', []);
    }

}
