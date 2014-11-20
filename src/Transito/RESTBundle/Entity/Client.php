<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class Client extends State {

    /**
     *
     * @Type("integer")
     */
    private $bill;

    function getBill() {
        return $this->bill;
    }

    function setBill($bill) {
        $this->bill = $bill;
    }

}
