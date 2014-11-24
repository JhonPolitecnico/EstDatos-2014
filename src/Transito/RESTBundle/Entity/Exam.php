<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class Exam {

    /**
     *
     * @Type("ArrayCollection<Transito\RESTBundle\Entity\DateType>")
     */
    private $dates;

    /**
     *
     * @Type("ArrayCollection<Transito\RESTBundle\Entity\NumericType>")
     */
    private $numerics;

    /**
     *
     * @Type("ArrayCollection<Transito\RESTBundle\Entity\TextType>")
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
