<?php

namespace Transito\LoginBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\RedirectResponse;

class LoginController extends Controller
{

    public function indexAction(Request $request)
    {
        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if ($loginManager->isLogged())
            return $this->redirect($this->generateUrl('index_homepage'));

        // Else Make Login Form
        $form = $this->createFormBuilder()
                ->add('username', 'text')
                ->add('password', 'password')
                ->getForm();
        do
        {
            // If form send
            if (!$request->isMethod('POST'))
                break;

            $form->handleRequest($request);

            // Is form not is valid
            if (!$form->isValid())
                break;

            $data = $form->getData();

            $Login = new \Transito\LoginBundle\Validations\Login();

            $Login->setUsername($data['username']);
            $Login->setPassword($data['password']);

            // Validate fields
            $validator = $this->get('validator');
            $errors = $validator->validate($Login);

            // If errors in fields
            if (count($errors) > 0)
                return $this->showForm($form, $errors);

            // Login user
            $ret = $loginManager->loginUser($Login->getUsername(), $Login->getPassword());
            if ($ret === false)
                return $this->showForm($form, $this->get('utils')->createErrorsMessageArray('Usuario o contraseña incorrectos'));

            // Send Redirect and cookie
            $cookie = $loginManager->getUserCookie();
            $response = new RedirectResponse($this->generateUrl('index_homepage'));
            $response->headers->setCookie($cookie);
            return $response;
        } while (FALSE);

        // Show login form
        return $this->showForm($form);
    }

    private function showForm($form, $errors = [])
    {
        return $this->render('TransitoMainBundle:Admin:login.html.twig', [
                    'form' => $form->createView(),
                    'errors' => $errors
        ]);
    }

    public function logOutAction()
    {
        $response = new RedirectResponse($this->generateUrl('index_homepage'));
        $response->headers->clearCookie($this->container->getParameter('cookieName'));
        return $response;
    }

}
