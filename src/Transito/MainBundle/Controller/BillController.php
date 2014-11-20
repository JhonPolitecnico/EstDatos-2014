<?php

namespace Transito\MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Transito\RESTBundle\Entity\Bill;

class BillController extends Controller {

    /**
     *
     * @var Bill
     */
    private $restSingleBillEntity;

    public function billAction($bill) {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged())
            return $this->redirect($this->generateUrl('login_page'));

        // prepare parameters

        $query = [
            'token' => $loginManager->getUser()->getToken()
        ];

        $post = [
            'bill' => $bill
        ];

        // get bill
        try {
            $this->restSingleBillEntity = $this->restSingleClientEntity = $this->get('rest')->postEntity(
                    '/bill', $post, 'Transito\RESTBundle\Entity\Bill', $query
            );
        } catch (\RuntimeException $exc) {
            return $this->render('TransitoMainBundle:Admin:500.html.twig');
        }
        
        return $this->render('TransitoMainBundle:Admin:bill.html.twig', [
                    'bill' => $this->restSingleBillEntity
        ]);
    }

}
