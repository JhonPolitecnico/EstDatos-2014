<?php

namespace Transito\MainBundle\Validations;

class Procedure {

    /**
     *
     * @var string
     */
    private $date;

    /**
     *
     * @var string
     */
    private $dni;

    /**
     *
     * @var string
     */
    private $name;

    function getDate() {
        return $this->date;
    }

    function getDni() {
        return $this->dni;
    }

    function getName() {
        return $this->name;
    }

    function setDate($date) {
        $this->date = $date;
    }

    function setDni($dni) {
        $this->dni = $dni;
    }

    function setName($name) {
        $this->name = $name;
    }

}
