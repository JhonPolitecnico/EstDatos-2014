<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class TextType {

    /**
     *
     * @Type("string")
     */
    private $question;

    /**
     *
     * @Type("string")
     */
    private $text;

    /**
     *
     * @Type("integer")
     */
    private $id;

    function getQuestion() {
        return $this->question;
    }

    function getText() {
        return $this->text;
    }

    function getId() {
        return $this->id;
    }

    function setQuestion($question) {
        $this->question = $question;
    }

    function setText($text) {
        $this->text = $text;
    }

    function setId($id) {
        $this->id = $id;
    }

}
