<?php

namespace Transito\MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Transito\RESTBundle\Entity\User;
use Transito\RESTBundle\Entity\Exam;
use Transito\RESTBundle\Entity\State;

class ExamController extends Controller {

    /**
     *
     * @var User
     */
    private $restUserEntity;

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

    /**
     *
     * @var \Symfony\Component\Form\FormBuilder 
     */
    private $form;

    /**
     *
     * @var string
     */
    private $type;

    /**
     *
     * @var integer
     */
    private $bill;

    /**
     *
     * @var \Symfony\Component\Validator\ConstraintViolationList
     */
    private $errors;

    /**
     *
     * @var string
     */
    private $attachment;

    public function speechTherapyAction(Request $request, $type, $bill) {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged())
            return $this->redirect($this->generateUrl('login_page'));

        $this->type = $type;
        $this->bill = $bill;

        $query = [
            'token' => $loginManager->getUser()->getToken(),
            'bill' => $this->bill
        ];

        try {
            $this->restUserEntity = $this->get('rest')->getEntity('/user/get', 'Transito\RESTBundle\Entity\User', $query);
        } catch (\RuntimeException $exc) {
            return $this->render('TransitoMainBundle:Admin:500.html.twig');
        }

        // Else make pau form
        $this->form = $this->createFormBuilder()
                ->add('attachment', 'file')
                ->add('observations', 'textarea')
                ->add('result', 'choice', [
                    'choices' => [0 => 'Rechazado', 1 => 'Aprobado', 2 => 'Aplazado'],
                ])
                ->getForm();

        do {
            // If form send
            if (!$request->isMethod('POST'))
                break;

            $this->form->handleRequest($request);

            // If form not is valid
            if (!$this->form->isValid())
                break;

            $data = $this->form->getData();

            $exam = new \Transito\MainBundle\Validations\ExamFile();

            $exam->setAttachment($data['attachment']);
            $exam->setObservations($data['observations']);
            $exam->setResult($data['result']);

            // Validate fields
            $validator = $this->get('validator');
            $this->errors = $validator->validate($exam);

            // If errors in fields
            if (count($this->errors) > 0)
                return $this->showFileForm();

            // validate file
            $file = file_get_contents($exam->getAttachment()->getRealPath());

            if (
                    !preg_match('/^(-\d(\.\d|),|\d(\.\d|),|-\d(\.\d|)|\d(\.\d|))+$/', $file) // number,...
                    or
                    substr_count($file, ',') != 7 // seven ","
                    or ! preg_match('/^\d$/', substr($file, -1, 1)) // end with a number
            ) {
                $this->errors->add(new \Transito\EntityBundle\ConstraintViolationError("El formato de archivo es invalido"));
                return $this->showFileForm();
            }

            // prepare parameters

            $query = [
                'token' => $loginManager->getUser()->getToken()
            ];

            $post = [
                'type' => $this->type,
                'bill' => $this->bill,
                'attachment' => $file,
                'observations' => $exam->getObservations(),
                'result' => $exam->getResult()
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

        // obtain the above stored test
        $query = [
            'token' => $loginManager->getUser()->getToken(),
            'type' => $this->type,
            'bill' => $this->bill
        ];

        try {
            $this->restExamEntity = $this->get('rest')->getEntity('/exam/get', 'Transito\RESTBundle\Entity\Exam', $query);
        } catch (\RuntimeException $exc) {
            return $this->render('TransitoMainBundle:Admin:500.html.twig');
        }

        $this->attachment = $this->restExamEntity->getAttachment();

        $this->form->get('observations')->setData($this->restExamEntity->getObservations());
        $this->form->get('result')->setData($this->restExamEntity->getResult());

        // Show exam form
        return $this->showFileForm();
    }

    private function showFileForm() {
        return $this->render('TransitoMainBundle:Admin:exam_file_manager.html.twig', [
                    'form' => $this->form->createView(),
                    'user' => $this->restUserEntity,
                    'attachment' => $this->attachment,
                    'errors' => $this->errors,
                    'bill' => $this->bill,
        ]);
    }

    public function indexAction(Request $request, $type, $bill) {

        // If logged then redirect to home page
        $loginManager = $this->get('login');
        if (!$loginManager->isLogged())
            return $this->redirect($this->generateUrl('login_page'));

        $this->type = $type;
        $this->bill = $bill;

        $query = [
            'token' => $loginManager->getUser()->getToken(),
            'bill' => $this->bill
        ];

        try {
            $this->restUserEntity = $this->get('rest')->getEntity('/user/get', 'Transito\RESTBundle\Entity\User', $query);
        } catch (\RuntimeException $exc) {
            return $this->render('TransitoMainBundle:Admin:500.html.twig');
        }

        // Else make pau form
        $this->form = $this->createFormBuilder(null, [
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
                ->add('observations', 'textarea')
                ->add('result', 'choice', [
                    'choices' => [0 => 'Rechazado', 1 => 'Aprobado', 2 => 'Aplazado'],
                ])
                ->getForm();

        do {
            // If form send
            if (!$request->isMethod('POST'))
                break;

            $this->form->handleRequest($request);

            // If form not is valid
            if (!$this->form->isValid())
                break;

            $data = $this->form->getData();

            $exam = new \Transito\MainBundle\Validations\Exam();
            $exam->setDates($data['dates']);
            $exam->setNumerics($data['numerics']);
            $exam->setTexts($data['texts']);
            $exam->setObservations($data['observations']);
            $exam->setResult($data['result']);

            // Validate fields
            $validator = $this->get('validator');
            $this->errors = $validator->validate($exam);

            // If errors in fields
            if (count($this->errors) > 0)
                return $this->showManagerForm();

            // prepare parameters

            $query = [
                'token' => $loginManager->getUser()->getToken()
            ];

            $post = [
                'type' => $this->type,
                'bill' => $this->bill,
                'dates' => $exam->getDates(),
                'numerics' => $exam->getNumerics(),
                'texts' => $exam->getTexts(),
                'observations' => $exam->getObservations(),
                'result' => $exam->getResult()
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

        // obtain the above stored test
        $query = [
            'token' => $loginManager->getUser()->getToken(),
            'type' => $this->type,
            'bill' => $this->bill
        ];

        try {
            $this->restExamEntity = $this->get('rest')->getEntity('/exam/get', 'Transito\RESTBundle\Entity\Exam', $query);
        } catch (\RuntimeException $exc) {
            return $this->render('TransitoMainBundle:Admin:500.html.twig');
        }

        $this->form->get('dates')->setData($this->restExamEntity->getDates());
        $this->form->get('numerics')->setData($this->restExamEntity->getNumerics());
        $this->form->get('texts')->setData($this->restExamEntity->getTexts());
        $this->form->get('observations')->setData($this->restExamEntity->getObservations());
        $this->form->get('result')->setData($this->restExamEntity->getResult());

        // Show exam form
        return $this->showManagerForm();
    }

    private function showManagerForm() {
        return $this->render('TransitoMainBundle:Admin:exam_manager.html.twig', [
                    'form' => $this->form->createView(),
                    'user' => $this->restUserEntity,
                    'errors' => $this->errors,
                    'type' => $this->type,
                    'bill' => $this->bill,
        ]);
    }

}
