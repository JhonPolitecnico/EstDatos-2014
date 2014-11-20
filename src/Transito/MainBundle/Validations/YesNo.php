<?php

namespace Transito\MainBundle\Validations;

class YesNo {

    /**
     *
     * @var string
     */
    private $question;

    /**
     *
     * @var boolean
     */
    private $yesNo;

    /**
     *
     * @var string
     */
    private $id;

    function getQuestion() {
        return $this->question;
    }

    function getYesNo() {
        return $this->yesNo;
    }

    function getId() {
        return $this->id;
    }

    function setQuestion($question) {
        $this->question = $question;
    }

    function setYesNo($yesNo) {
        $this->yesNo = $yesNo;
    }

    function setId($id) {
        $this->id = $id;
    }

}
