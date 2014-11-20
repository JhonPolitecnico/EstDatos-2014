<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

/**
 * Description of Pau
 *
 * @author Hax0r
 */
class Pau {

    /**
     * @Type("integer")
     */
    private $id;

    /**
     * @Type("string")
     */
    private $name;

    /**
     * @Type("string")
     */
    private $location;

    /**
     * @Type("string")
     */
    private $phone;

    /**
     * @Type("string")
     */
    private $email;

    /**
     * @Type("string")
     */
    private $operation;

    function getId() {
        return $this->id;
    }

    function getName() {
        return $this->name;
    }

    function getLocation() {
        return $this->location;
    }

    function getPhone() {
        return $this->phone;
    }

    function getEmail() {
        return $this->email;
    }

    function getOperation() {
        return $this->operation;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setName($name) {
        $this->name = $name;
    }

    function setLocation($location) {
        $this->location = $location;
    }

    function setPhone($phone) {
        $this->phone = $phone;
    }

    function setEmail($email) {
        $this->email = $email;
    }

    function setOperation($operation) {
        $this->operation = $operation;
    }

}
