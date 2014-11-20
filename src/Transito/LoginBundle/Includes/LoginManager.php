<?php

namespace Transito\LoginBundle\Includes;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Cookie;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Transito\EntityBundle\User;

class LoginManager extends Controller {

    /**
     *
     * @var \Transito\RESTBundle\Entity\Login
     */
    private $restLoginEntity;

    /**
     *
     * @var User
     */
    protected $user;

    /**
     * 
     * @return User
     */
    public function getUser() {
        return $this->user;
    }

    public function loadUserInfo() {
        $this->isLogged();
    }

    public function isLogged() {
        // just make a call to the DB
        if (!is_null($this->user))
            return true;

        $request = $this->get('request');
        $cookies = $request->cookies;
        $cookieName = $this->container->getParameter('cookieName');

        if (!$cookies->has($cookieName))
            return false;

        $data = $cookies->get($cookieName);
        $data = $this->get('utils')->decrypt($this->container->getParameter('secret'), $data);

        if ($data === false)
            return false;

        if (!$this->get('utils')->isSerialized($data))
            return false;

        $user = unserialize($data);

        if ($user instanceof User) {
            $this->user = $user;
            return true;
        }

        return false;
    }

    /**
     * REST login
     * 
     * @param string $username
     * @param string $password
     * @return boolean
     */
    public function loginUser($username, $password) {

        $data = [
            'username' => $username,
            'password' => $password
        ];

        try {
            $this->restLoginEntity = $this->get('rest')->postEntity('/login', $data, 'Transito\RESTBundle\Entity\Login');
        } catch (\RuntimeException $exc) {
            return false;
        }

        if ($this->restLoginEntity->getStatus() === \Transito\RESTBundle\Entity\Login::SUCCESS) {
            $this->setUser($username, $this->restLoginEntity->getToken(), $this->restLoginEntity->getRole());
            return true;
        }
        return false;
    }

    public function getUserCookie() {
        $enc = $this->get('utils')->encrypt($this->container->getParameter('secret'), serialize($this->user));
        return new Cookie($this->container->getParameter('cookieName'), $enc, time() + 60 * 60 * 24, '/', null, false, false);
    }

    private function setUser($username, $token, $role) {
        $this->user = new User($username, $token, $role);
    }

}
