<?php

namespace Transito\EntityBundle;

class User {

    const DOCTOR = 1;
    const FUNCTIONARY = 2;

    /**
     *
     * @var string
     */
    private $username;

    /**
     *
     * @var string
     */
    private $token;

    /**
     *
     * @var integer
     */
    private $role;

    function __construct($username, $token, $role) {
        $this->username = $username;
        $this->token = $token;
        $this->role = $role;
    }

    function getUsername() {
        return $this->username;
    }

    function getToken() {
        return $this->token;
    }

    function getRole() {
        return $this->role;
    }

    function setUsername($username) {
        $this->username = $username;
    }

    function setToken($token) {
        $this->token = $token;
    }

    function setRole($role) {
        $this->role = $role;
    }

}
