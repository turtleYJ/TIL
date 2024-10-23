<?php
include_once APPPATH.'libraries/Template_.php';
$tpl = new Template_;
$tpl->define('board_update', 'board_update.html');
$tpl->assign('post', $post);
$tpl->print_('board_update');
?>