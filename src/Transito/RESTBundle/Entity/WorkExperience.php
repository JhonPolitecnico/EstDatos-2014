<?php

namespace Transito\RESTBundle\Entity;

use JMS\Serializer\Annotation\Type;

class WorkExperience {

    /**
     *
     * @Type("string")
     */
    private $immediate_boss;

    /**
     *
     * @Type("string")
     */
    private $company;

    /**
     *
     * @Type("string")
     */
    private $date_of_admission;

    /**
     *
     * @Type("string")
     */
    private $departure_date;

    /**
     *
     * @Type("string")
     */
    private $functions;

    /**
     *
     * @Type("string")
     */
    private $achievements;

    function getImmediate_boss() {
        return $this->immediate_boss;
    }

    function getCompany() {
        return $this->company;
    }

    function getDate_of_admission() {
        return $this->date_of_admission;
    }

    function getDeparture_date() {
        return $this->departure_date;
    }

    function getFunctions() {
        return $this->functions;
    }

    function getAchievements() {
        return $this->achievements;
    }

    function setImmediate_boss($immediate_boss) {
        $this->immediate_boss = $immediate_boss;
    }

    function setCompany($company) {
        $this->company = $company;
    }

    function setDate_of_admission($date_of_admission) {
        $this->date_of_admission = $date_of_admission;
    }

    function setDeparture_date($departure_date) {
        $this->departure_date = $departure_date;
    }

    function setFunctions($functions) {
        $this->functions = $functions;
    }

    function setAchievements($achievements) {
        $this->achievements = $achievements;
    }

}
