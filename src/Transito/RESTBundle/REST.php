<?php

namespace Transito\RESTBundle;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class REST extends Controller {

    /**
     *
     * @var \Guzzle\Http\Client
     */
    private $client;

    /**
     *
     * @var \JMS\Serializer\Serializer
     */
    private $serializer;

    const FORMAT = 'json';

    public function setContainer(\Symfony\Component\DependencyInjection\ContainerInterface $container = null) {
        parent::setContainer($container);
        $this->client = $this->get('transit.client');
        $this->serializer = $this->get('jms_serializer');
    }

    private function renameClass($class) {

        $classes = [
            'ArrayCollection<' => 'Doctrine\Common\Collections\ArrayCollection<'
        ];

        foreach ($classes as $left => $replace) {

            if (substr($class, 0, strlen($left)) == $left)
                $class = str_replace($left, $replace, $class);
        }

        return $class;
    }

    public function getEntity($path, $class, $query = []) {

        $class = $this->renameClass($class);

        $request = $this->client->get(
                $path, [], [
            'query' => $query
                ]
        );

        $response = $request->send();

        return $this->serializer->deserialize($response->getBody(), $class, self::FORMAT);
    }

    public function postEntity($path, $post, $class, $query = []) {

        $class = $this->renameClass($class);

        $request = $this->client->post(
                $path, '', $this->serializer->serialize($post, self::FORMAT), [
            'query' => $query
                ]
        );

        $response = $request->send();

        return $this->serializer->deserialize($response->getBody(), $class, self::FORMAT);
    }

}
