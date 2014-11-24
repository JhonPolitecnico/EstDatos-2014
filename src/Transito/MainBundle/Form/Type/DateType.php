<?php

namespace Transito\MainBundle\Form\Type;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class DateType extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {

        $builder
                ->add('question', 'text')
                ->add('date', 'text')
                ->add('id', 'hidden', ['data' => '__ID__'])
        ;
    }

    public function setDefaultOptions(OptionsResolverInterface $resolver) {
        parent::setDefaultOptions($resolver);
        $resolver->setDefaults(array(
            'data_class' => 'Transito\MainBundle\Validations\DateType',
            'cascade_validation' => true,
        ));
    }

    public function getName() {
        return 'qDateType';
    }

}
