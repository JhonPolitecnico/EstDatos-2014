<?php

namespace Transito\MainBundle\Validations;

class Record {

    /**
     *
     * @var string
     */
    private $paus;

    /**
     *
     * @var string
     */
    private $firstDate;

    /**
     *
     * @var string
     */
    private $lastDate;

    function getPaus() {
        return $this->paus;
    }

    function getFirstDate() {
        return $this->firstDate;
    }

    function getLastDate() {
        return $this->lastDate;
    }

    function setPaus($paus) {
        $this->paus = $paus;
    }

    function setFirstDate($firstDate) {
        $this->firstDate = $firstDate;
    }

    function setLastDate($lastDate) {
        $this->lastDate = $lastDate;
    }

}
