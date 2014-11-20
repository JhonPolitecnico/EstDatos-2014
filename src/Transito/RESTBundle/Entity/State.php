<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class State {

    const ERROR = 'error';
    const SUCCESS = 'success';

    /**
     * @Type("string")
     */
    private $status;

    function getStatus() {
        return $this->status;
    }

    function setStatus($status) {

        switch ($status) {
            case self::SUCCESS:
            case self::ERROR:
                $this->status = $status;
                break;
            default:
                $this->status = self::ERROR;
        }
    }

}
