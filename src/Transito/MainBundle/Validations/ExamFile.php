<?php

namespace Transito\MainBundle\Validations;

class ExamFile {

    /**
     *
     * @var \Symfony\Component\HttpFoundation\File\UploadedFile
     */
    private $attachment;

    /**
     *
     * @var string
     */
    private $observations;

    /**
     *
     * @var integer
     */
    private $result;

    function getAttachment() {
        return $this->attachment;
    }

    function getObservations() {
        return $this->observations;
    }

    function getResult() {
        return $this->result;
    }

    function setAttachment($attachment) {
        $this->attachment = $attachment;
    }

    function setObservations($observations) {
        $this->observations = $observations;
    }

    function setResult($result) {
        $this->result = $result;
    }

}
