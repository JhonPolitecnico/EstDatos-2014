<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class NumericType {

    /**
     *
     * @Type("string")
     */
    private $question;

    /**
     *
     * @Type("integer")
     */
    private $numeric;

    /**
     *
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
