<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class Record extends State {

    /**
     *
     * @Type("integer")
     */
    private $processedUsers;

    /**
     *
     * @Type("integer")
     */
    private $invoicedValue;

    /**
     *
     * @Type("integer")
     */
    private $invoicedValueIva;

    /**
     *
     * @Type("integer")
     */
    private $iva;

    function getProcessedUsers() {
        return $this->processedUsers;
    }

    function getInvoicedValue() {
        return $this->invoicedValue;
    }

    function getInvoicedValueIva() {
        return $this->invoicedValueIva;
    }

    function getIva() {
        return $this->iva;
    }

    function setProcessedUsers($processedUsers) {
        $this->processedUsers = $processedUsers;
    }

    function setInvoicedValue($invoicedValue) {
        $this->invoicedValue = $invoicedValue;
    }

    function setInvoicedValueIva($invoicedValueIva) {
        $this->invoicedValueIva = $invoicedValueIva;
    }

    function setIva($iva) {
        $this->iva = $iva;
    }

}
