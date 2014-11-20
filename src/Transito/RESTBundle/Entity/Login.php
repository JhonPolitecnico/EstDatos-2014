<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class Login {

    const ERROR = 'error';
    const SUCCESS = 'success';

    /**
     * @Type("string")
     */
    private $status;

    /**
     * @Type("string")
     */
    private $token;

    /**
     *
     * @Type("integer")
     */
    private $role;

    function getStatus() {
        return $this->status;
    }

    function getToken() {
        return $this->token;
    }

    function getRole() {
        return $this->role;
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

    function setToken($token) {
        $this->token = $token;
    }

    function setRole($role) {
        $this->role = $role;
    }

}
