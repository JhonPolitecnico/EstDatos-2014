<?php

namespace Transito\MainBundle\Validations;

class NumericType {

    /**
     *
     * @var string
     */
    private $question;

    /**
     *
     * @var integer
     */
    private $numeric;

    /**
     *
     * @var integer
     */
    private $id;

    function getQuestion() {
        return $this->question;
    }

    function getNumeric() {
        return $this->numeric;
    }

    function getId() {
        return $this->id;
    }

    function setQuestion($question) {
        $this->question = $question;
    }

    function setNumeric($numeric) {
        $this->numeric = $numeric;
    }

    function setId($id) {
        $this->id = $id;
    }

}
