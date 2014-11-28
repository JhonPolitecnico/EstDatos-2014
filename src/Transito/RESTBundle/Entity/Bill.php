<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;
use JMS\Serializer\Annotation\SerializedName;

class Bill {

    /**
     *
     * @Type("integer")
     */
    private $id;

    /**
     *
     * @Type("string")
     */
    private $date;

    /**
     *
     * @Type("integer")
     */
    private $payment;

    /**
     *
     * @Type("string")
     * @SerializedName("client_name")
     */
    private $clientName;

    /**
     *
     * @Type("string")
     * @SerializedName("client_dni")
     */
    private $clientDni;

    /**
     *
     * @Type("string")
     * @SerializedName("client_mail")
     */
    private $clientMail;

    /**
     *
     * @Type("string")
     * @SerializedName("pau_name")
     */
    private $pauName;

    function getId() {
        return $this->id;
    }

    function getDate() {
        return $this->date;
    }

    function getPayment() {
        return $this->payment;
    }

    function getClientName() {
        return $this->clientName;
    }

    function getClientDni() {
        return $this->clientDni;
    }

    function getClientMail() {
        return $this->clientMail;
    }

    function getPauName() {
        return $this->pauName;
    }

    function setId($id) {
        $this->id = $id;
    }

    function setDate($date) {
        $this->date = $date;
    }

    function setPayment($payment) {
        $this->payment = $payment;
    }

    function setClientName($clientName) {
        $this->clientName = $clientName;
    }

    function setClientDni($clientDni) {
        $this->clientDni = $clientDni;
    }

    function setClientMail($clientMail) {
        $this->clientMail = $clientMail;
    }

    function setPauName($pauName) {
        $this->pauName = $pauName;
    }

}
