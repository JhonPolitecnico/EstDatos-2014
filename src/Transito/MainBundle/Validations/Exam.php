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

    function getDates() {
        return $this->dates;
    }

    function getNumerics() {
        return $this->numerics;
    }

    function getTexts() {
        return $this->texts;
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

}
