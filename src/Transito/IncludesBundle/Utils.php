<?php

namespace Transito\IncludesBundle;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class Utils extends Controller
{

    public function createErrorsMessageArray($messages)
    {
        $ret = Array();

        if (!is_array($messages))
            $messages = Array($messages);

        foreach ($messages as $message)
            array_push($ret, Array('message' => $message));

        return $ret;
    }

    public function isSerialized($str)
    {
        return ($str == serialize(false) || @unserialize($str) !== false);
    }

    public function encrypt($key, $data)
    {
        $cp = mcrypt_module_open(MCRYPT_3DES, '', 'cbc', '');
        $key = substr($key, 0, mcrypt_enc_get_key_size($cp));
        $iv = '';
        for ($i = 1; $i <= mcrypt_enc_get_iv_size($cp); $i++)
            $iv .= chr(mt_rand(0, 255));
        mcrypt_generic_init($cp, $key, $iv);
        $enc = mcrypt_generic($cp, $data);
        mcrypt_generic_deinit($cp);
        mcrypt_module_close($cp);
        return base64_encode(gzdeflate($iv . $enc, 9));
    }

    public function decrypt($key, $data)
    {
        $data = @gzinflate(@base64_decode($data));

        if ($data === false)
            return false;

        $cp = mcrypt_module_open(MCRYPT_3DES, '', 'cbc', '');
        $key = substr($key, 0, mcrypt_enc_get_key_size($cp));
        $iv = substr($data, 0, mcrypt_enc_get_iv_size($cp));
        $data = substr($data, mcrypt_enc_get_iv_size($cp));
        mcrypt_generic_init($cp, $key, $iv);
        $dec = mdecrypt_generic($cp, $data);
        mcrypt_generic_deinit($cp);
        mcrypt_module_close($cp);
        return $dec;
    }

}
