<?php
include_once APPPATH.'libraries/Template_.php';

$tpl = new Template_;
$tpl->define('loop', 'loop.html');
$tpl->assign('title', 'power of 2');
$loop = array();
for ($i=1; $i<=3; $i++) {
    $loop[] = array(
        'exponent'  =>$i,
        'power'     =>pow(2, $i),
    );
}
$tpl->assign('row', $loop);
$tpl->print_('loop');
?>