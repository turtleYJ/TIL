<?php
class Board extends CI_Controller {

    public function __construct()
    {
        parent::__construct();
        $this->load->model('board_model');
    }

    public function index()
    {
        $data['posts'] = $this->board_model->get_posts();

        // $this->load->view('common/header');
        $this->load->helper('url');
        $this->load->view('board/index', $data);
        // $this->load->view('common/footer');
    }

    public function write()
    {
        $this->load->helper('form');
        $this->load->library('form_validation');
        $this->load->view('board/write');
    }

}