<?php

namespace Transito\MainBundle\Validations;

class Exam {

    /**
     *
     * @var DateType[]
     */
    private $dates;

    /**
     *
     * @var NumericType[]
     */
    private $numerics;

    /**
     *
     * @var TextType[]
     */
    private $texts;

    /**
     *
     * @var string
     */
    private $observations;

    /**
     *
     * @var integer
     */
    private $result;

    function getDates() {
        return $this->dates;
    }

    function getNumerics() {
        return $this->numerics;
    }

    function getTexts() {
        return $this->texts;
    }

    function getObservations() {
        return $this->observations;
    }

    function getResult() {
        return $this->result;
    }

    function setDates(array $dates) {
        $this->dates = $dates;
    }

    function setNumerics(array $numerics) {
        $this->numerics = $numerics;
    }

    function setTexts(array $texts) {
        $this->texts = $texts;
    }

    function setObservations($observations) {
        $this->observations = $observations;
    }

    function setResult($result) {
        $this->result = $result;
    }

}
