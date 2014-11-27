<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class Exam {

    /**
     *
     * @Type("ArrayCollection<Transito\MainBundle\Validations\DateType>")
     */
    private $dates;

    /**
     *
     * @Type("ArrayCollection<Transito\MainBundle\Validations\NumericType>")
     */
    private $numerics;

    /**
     *
     * @Type("ArrayCollection<Transito\MainBundle\Validations\TextType>")
     */
    private $texts;

    /**
     *
     * @Type("string")
     */
    private $attachment;

    /**
     *
     * @Type("string")
     */
    private $observations;

    /**
     *
     * @Type("integer")
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

    function getAttachment() {
        return $this->attachment;
    }

    function getObservations() {
        return $this->observations;
    }

    function getResult() {
        return $this->result;
    }

    function setDates($dates) {
        $this->dates = $dates;
    }

    function setNumerics($numerics) {
        $this->numerics = $numerics;
    }

    function setTexts($texts) {
        $this->texts = $texts;
    }

    function setAttachment($attachment) {
        $this->attachment = $attachment;
    }

    function setObservations($observations) {
        $this->observations = $observations;
    }

    function setResult($result) {
        $this->result = $result;
    }

}
