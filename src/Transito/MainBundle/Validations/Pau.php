<?php

namespace Transito\MainBundle\Validations;

class Pau {

    /**
     *
     * @var string
     */
    private $name;

    /**
     *
     * @var string
     */
    private $location;

    /**
     *
     * @var string
     */
    private $email;

    /**
     *
     * @var string
     */
    private $operation;

    function getName() {
        return $this->name;
    }

    function getLocation() {
        return $this->location;
    }

    function getEmail() {
        return $this->email;
    }

    function getOperation() {
        return $this->operation;
    }

    function setName($name) {
        $this->name = $name;
    }

    function setLocation($location) {
        $this->location = $location;
    }

    function setEmail($email) {
        $this->email = $email;
    }

    function setOperation($operation) {
        $this->operation = $operation;
    }

}
