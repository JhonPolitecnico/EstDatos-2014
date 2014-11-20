<?php

namespace Transito\MainBundle\Form\Type;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class WorkExperienceType extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {

        $builder
                ->add('immediateBoss', 'text')
                ->add('company', 'text')
                ->add('dateOfAdmission', 'text')
                ->add('departureDate', 'text')
                ->add('functions', 'text')
                ->add('achievements', 'text')
        ;
    }

    public function setDefaultOptions(OptionsResolverInterface $resolver) {
        parent::setDefaultOptions($resolver);
        $resolver->setDefaults(array(
            'data_class' => 'Transito\MainBundle\Validations\WorkExperience',
            'cascade_validation' => true,
        ));
    }

    public function getName() {
        return 'workExperience';
    }

}
