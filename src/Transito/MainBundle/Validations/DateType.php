<?php

namespace Transito\MainBundle\Validations;

use JMS\Serializer\Annotation\Type;

class DateType {

    /**
     *
     * @var string
     * @Type("string")
     */
    private $question;

    /**
     *
     * @var string
     * @Type("string")
     */
    private $date;

    /**
     *
     * @var integer
     * @Type("integer")
     */
    private $id;

    function getQuestion() {
        return $this->question;
    }

    function getDate() {
        return $this->date;
    }

    function getId() {
        return $this->id;
    }

    function setQuestion($question) {
        $this->question = $question;
    }

    function setDate($date) {
        $this->date = $date;
    }

    function setId($id) {
        $this->id = $id;
    }

}
