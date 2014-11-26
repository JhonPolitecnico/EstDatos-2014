<?php

namespace Transito\MainBundle\Validations;

use JMS\Serializer\Annotation\Type;

class NumericType {

    /**
     *
     * @var string
     * @Type("string")
     */
    private $question;

    /**
     *
     * @var integer
     * @Type("integer")
     */
    private $numeric;

    /**
     *
     * @var integer
     * @Type("integer")
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
