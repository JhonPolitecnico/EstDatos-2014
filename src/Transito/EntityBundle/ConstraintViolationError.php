<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

namespace Transito\EntityBundle;

/**
 * Description of ConstraintViolationError
 *
 * @author Hax0r
 */
class ConstraintViolationError implements \Symfony\Component\Validator\ConstraintViolationInterface {

    /**
     *
     * @var string
     */
    private $message;

    public function __construct($message) {
        $this->message = $message;
    }

    public function getCode() {
        return $this->message;
    }

    public function getInvalidValue() {
        return $this->message;
    }

    public function getMessage() {
        return $this->message;
    }

    public function getMessageParameters() {
        return $this->message;
    }

    public function getMessagePluralization() {
        return $this->message;
    }

    public function getMessageTemplate() {
        return $this->message;
    }

    public function getPropertyPath() {
        return $this->message;
    }

    public function getRoot() {
        return $this->message;
    }

}
