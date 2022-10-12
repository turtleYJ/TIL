<?php
include_once APPPATH.'libraries/Template_.class.php';
$tpl = new Template_;
$tpl->define('test', 'test.tpl');
$tpl->assign(array(
    'title'     => 'First Template_',
    'content'   => 'Fill me in',
));
$tpl->print_('test');
?>