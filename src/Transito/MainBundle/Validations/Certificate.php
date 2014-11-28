<?php

namespace Transito\MainBundle\Validations;

class Certificate {

    /**
     *
     * @var integer
     */
    private $result;

    function getResult() {
        return $this->result;
    }

    function setResult($result) {
        $this->result = $result;
    }

}
