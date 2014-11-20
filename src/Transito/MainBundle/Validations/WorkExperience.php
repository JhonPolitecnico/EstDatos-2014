<?php

namespace Transito\MainBundle\Validations;

class WorkExperience {

    /**
     *
     * @var string
     */
    private $immediateBoss;

    /**
     *
     * @var string
     */
    private $company;

    /**
     *
     * @var string
     */
    private $dateOfAdmission;

    /**
     *
     * @var string
     */
    private $departureDate;

    /**
     *
     * @var string
     */
    private $functions;

    /**
     *
     * @var string
     */
    private $achievements;

    function getImmediateBoss() {
        return $this->immediateBoss;
    }

    function getCompany() {
        return $this->company;
    }

    function getDateOfAdmission() {
        return $this->dateOfAdmission;
    }

    function getDepartureDate() {
        return $this->departureDate;
    }

    function getFunctions() {
        return $this->functions;
    }

    function getAchievements() {
        return $this->achievements;
    }

    function setImmediateBoss($immediateBoss) {
        $this->immediateBoss = $immediateBoss;
    }

    function setCompany($company) {
        $this->company = $company;
    }

    function setDateOfAdmission($dateOfAdmission) {
        $this->dateOfAdmission = $dateOfAdmission;
    }

    function setDepartureDate($departureDate) {
        $this->departureDate = $departureDate;
    }

    function setFunctions($functions) {
        $this->functions = $functions;
    }

    function setAchievements($achievements) {
        $this->achievements = $achievements;
    }

}
