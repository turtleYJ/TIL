<?php
include_once APPPATH.'libraries/Template_.php';

$tpl = new Template_;
$tpl->define('test', 'test.html');
$tpl->assign(array(
    'title'     => 'First Template_',
    'content'   => 'Fill me in',
));
$tpl->print_('test');
?>