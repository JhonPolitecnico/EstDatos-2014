<?php

namespace Transito\MainBundle\Validations;

class TextType {

    /**
     *
     * @var string
     */
    private $question;

    /**
     *
     * @var string
     */
    private $text;

    /**
     *
     * @var integer
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
