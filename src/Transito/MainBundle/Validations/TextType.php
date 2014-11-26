<?php

namespace Transito\MainBundle\Validations;

use JMS\Serializer\Annotation\Type;

class TextType {

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
    private $text;

    /**
     *
     * @var integer
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
