<?php

namespace Transito\MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Transito\RESTBundle\Entity\Exam;
use Transito\RESTBundle\Entity\State;

class ExamController extends Controller {

    /**
     *
     * @var Exam
     */
    private $restExamEntity;

    /**
     *
     * @var State
     */
    private $restStateEntity;

    public function indexAction(Request $request, $type, $bill) {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged())
            return $this->redirect($this->generateUrl('login_page'));


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

        // Else make pau form
        $form = $this->createFormBuilder(null, [
                    'validation_groups' => ['dates', 'numerics', 'texts']
                ])
                ->add('dates', 'collection', [
                    'type' => new \Transito\MainBundle\Form\Type\DateType(),
                    'allow_add' => true,
                    'allow_delete' => true,
                        ]
                )
                ->add('numerics', 'collection', [
                    'type' => new \Transito\MainBundle\Form\Type\NumericType(),
                    'allow_add' => true,
                    'allow_delete' => true,
                        ]
                )
                ->add('texts', 'collection', [
                    'type' => new \Transito\MainBundle\Form\Type\TextType(),
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

            $exam = new \Transito\MainBundle\Validations\Exam();
            $exam->setDates($data['dates']);
            $exam->setNumerics($data['numerics']);
            $exam->setTexts($data['texts']);

            // Validate fields
            $validator = $this->get('validator');
            $errors = $validator->validate($exam);

            // If errors in fields
            if (count($errors) > 0)
                return $this->showManagerForm($form, $type, $bill, $errors);

            // prepare parameters

            $query = [
                'token' => $loginManager->getUser()->getToken()
            ];

            $post = [
                'type' => $type,
                'bill' => $bill,
                'dates' => $exam->getDates(),
                'numerics' => $exam->getNumerics(),
                'texts' => $exam->getTexts()
            ];

            // send exam
            try {
                $this->restStateEntity = $this->get('rest')->postEntity(
                        '/exam/process', $post, 'Transito\RESTBundle\Entity\State', $query
                );
            } catch (\RuntimeException $exc) {
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
            }

            // redirect to procedures
            if ($this->restStateEntity->getStatus() == State::SUCCESS)
                return $this->redirect(
                                $this->generateUrl(
                                        'procedure_list_page'
                                )
                );
            else
                return $this->render('TransitoMainBundle:Admin:500.html.twig');
        } while (FALSE);

        // Show exam form
        return $this->showManagerForm($form, $type, $bill);
    }

    private function showManagerForm($form, $type, $bill, $errors = []) {
        return $this->render('TransitoMainBundle:Admin:exam_manager.html.twig', [
                    'form' => $form->createView(),
                    'errors' => $errors,
                    'type' => $type,
                    'bill' => $bill,
        ]);
    }

}
