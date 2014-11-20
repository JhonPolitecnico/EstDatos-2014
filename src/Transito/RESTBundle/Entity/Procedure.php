<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class Procedure {

    /**
     *
     * @Type("integer")
     */
    private $bill;

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
    private $date;

    /**
     *
     * @Type("boolean")
     */
    private $speechTherapy;

    /**
     *
     * @Type("boolean")
     */
    private $psychological;

    /**
     *
     * @Type("boolean")
     */
    private $physical;

    /**
     *
     * @Type("boolean")
     */
    private $optometry;

    function getBill() {
        return $this->bill;
    }

    function getDni() {
        return $this->dni;
    }

    function getName() {
        return $this->name;
    }

    function getDate() {
        return $this->date;
    }

    function getSpeechTherapy() {
        return $this->speechTherapy;
    }

    function getPsychological() {
        return $this->psychological;
    }

    function getPhysical() {
        return $this->physical;
    }

    function getOptometry() {
        return $this->optometry;
    }

    function setBill($bill) {
        $this->bill = $bill;
    }

    function setDni($dni) {
        $this->dni = $dni;
    }

    function setName($name) {
        $this->name = $name;
    }

    function setDate($date) {
        $this->date = $date;
    }

    function setSpeechTherapy($speechTherapy) {
        $this->speechTherapy = $speechTherapy;
    }

    function setPsychological($psychological) {
        $this->psychological = $psychological;
    }

    function setPhysical($physical) {
        $this->physical = $physical;
    }

    function setOptometry($optometry) {
        $this->optometry = $optometry;
    }

}
