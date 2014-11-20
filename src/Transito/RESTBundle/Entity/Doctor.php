<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class Doctor {

    /**
     *
     * @Type("integer")
     */
    private $id;

    /**
     *
     * @Type("string")
     */
    private $dni;

    /**
     *
     * @Type("string")
     */
    private $name;

    /**
     *
     * @Type("string")
     */
    private $birthday;

    /**
     *
     * @Type("string")
     */
    private $location;

    /**
     *
     * @Type("string")
     */
    private $phone;

    /**
     *
     * @Type("string")
     */
    private $cellphone;

    /**
     *
     * @Type("string")
     */
    private $email;

    /**
     *
     * @Type("ArrayCollection<Transito\MainBundle\Validations\WorkExperience>")
     */
    private $work_experience;

    function getId() {
        return $this->id;
    }

    function getDni() {
        return $this->dni;
    }

    function getName() {
        return $this->name;
    }

    function getBirthday() {
        return $this->birthday;
    }

    function getLocation() {
        return $this->location;
    }

    function getPhone() {
        return $this->phone;
    }

    function getCellphone() {
        return $this->cellphone;
    }

    function getEmail() {
        return $this->email;
    }

    function getWork_experience() {
        return $this->work_experience;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setDni($dni) {
        $this->dni = $dni;
    }

    function setName($name) {
        $this->name = $name;
    }

    function setBirthday($birthday) {
        $this->birthday = $birthday;
    }

    function setLocation($location) {
        $this->location = $location;
    }

    function setPhone($phone) {
        $this->phone = $phone;
    }

    function setCellphone($cellphone) {
        $this->cellphone = $cellphone;
    }

    function setEmail($email) {
        $this->email = $email;
    }

    function setWork_experience($work_experience) {
        $this->work_experience = $work_experience;
    }

}
