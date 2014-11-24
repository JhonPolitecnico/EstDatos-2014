<?php

namespace Transito\MainBundle\Validations;

class DateType {

    /**
     *
     * @var string
     */
    private $question;

    /**
     *
     * @var string
     */
    private $date;

    /**
     *
     * @var integer
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
