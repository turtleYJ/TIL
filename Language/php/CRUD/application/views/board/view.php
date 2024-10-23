<?php
include_once APPPATH.'libraries/Template_.php';
$tpl = new Template_;
$tpl->define('board_view', 'board_view.html');
$tpl->assign('post', $post);
$tpl->print_('board_view');
?>