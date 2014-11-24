<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class DateType {

    /**
     *
     * @Type("string")
     */
    private $question;

    /**
     *
     * @Type("string")
     */
    private $date;

    /**
     *
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
