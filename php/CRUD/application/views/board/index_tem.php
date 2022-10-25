<?php
include_once APPPATH.'libraries/Template_.php';
$tpl = new Template_;
$tpl->define('board_index', 'board_index.html');
$tpl->assign('postA_item', $postA);
$tpl->assign('postB_item', $postB);
$tpl->assign('postC_item', $postC);
$tpl->print_('board_index');
?>