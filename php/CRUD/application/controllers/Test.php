<?php
class Test extends CI_Controller {

    public function __construct()
    {
        parent::__construct();
    }

    public function index()
    {
        $this->load->view('tpl/test');
    }

    public function loop()
    {
        $this->load->view('tpl/loop');
    }
}