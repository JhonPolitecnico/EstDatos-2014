<?php

namespace Transito\MainBundle\Validations;

class Doctor {

    /**
     *
     * @var string
     */
    private $dni;

    /**
     *
     * @var string
     */
    private $firstName;

    /**
     *
     * @var string
     */
    private $lastName;

    /**
     *
     * @var string
     */
    private $firstSurname;

    /**
     *
     * @var string
     */
    private $lastSurname;

    /**
     *
     * @var string
     */
    private $birthday;

    /**
     *
     * @var string
     */
    private $location;

    /**
     *
     * @var string
     */
    private $phone;

    /**
     *
     * @var string
     */
    private $cellphone;

    /**
     *
     * @var string
     */
    private $email;

    /**
     *
     * @var array<Transito\EntityBundle\WorkExperience>
     */
    private $workExperience;

    function getDni() {
        return $this->dni;
    }

    function getFirstName() {
        return $this->firstName;
    }

    function getLastName() {
        return $this->lastName;
    }

    function getFirstSurname() {
        return $this->firstSurname;
    }

    function getLastSurname() {
        return $this->lastSurname;
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

    function getWorkExperience() {
        return $this->workExperience;
    }

    function setDni($dni) {
        $this->dni = $dni;
    }

    function setFirstName($firstName) {
        $this->firstName = $firstName;
    }

    function setLastName($lastName) {
        $this->lastName = $lastName;
    }

    function setFirstSurname($firstSurname) {
        $this->firstSurname = $firstSurname;
    }

    function setLastSurname($lastSurname) {
        $this->lastSurname = $lastSurname;
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

    function setWorkExperience($workExperience) {
        $this->workExperience = $workExperience;
    }

}
