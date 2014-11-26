<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class User {

    /**
     *
     * @Type("string")
     */
    private $name;

    function getName() {
        return $this->name;
    }

    function setName($name) {
        $this->name = $name;
    }

}
