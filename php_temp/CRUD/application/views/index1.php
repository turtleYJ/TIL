<?php
include $_SERVER['DOCUMENT_ROOT'].'/application/libraries/Templateclass.php';
$tpl = new Templateclass;
$tpl->template_dir = $_SERVER['DOCUMENT_ROOT'].'/application/views';
$tpl->compile_dir = $_SERVER['DOCUMENT_ROOT'].'/_compile';
$tpl->define('index1', 'index1.tpl');
$tpl->assign(array(
    'title'  =>'First Template_',
    'content'=>'Fill me in',
));
$tpl->print_('index1');
?>