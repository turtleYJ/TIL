<?php
class Board extends CI_Controller {

    public function __construct()
    {
        parent::__construct();
        $this->load->helper('url');
        $this->load->model('board_model');
    }

    public function index()
    {
        $data['postA'] = $this->board_model->get_posts('a');
        $data['postB'] = $this->board_model->get_posts('b');
        $data['postC'] = $this->board_model->get_posts('c');
        
        // $this->load->view('common/header');
        $this->load->view('board/index_tem', $data);
        // $this->load->view('common/footer');
    }

    public function write($boardId = FALSE)
    {
        

        if ($boardId === FALSE) {
            
            $this->load->helper('form');
            $this->load->library('form_validation');
    
            $this->form_validation->set_rules('title', 'Title', 'required');
            $this->form_validation->set_rules('text', 'Text', 'required');

            if ($this->form_validation->run() === FALSE)
            {
                $this->load->view('board/write');
            }
            else
            {
                $this->board_model->set_posts();
                $this->load->view('board/success');
            }
        } else {

            $title = $this->input->post('title');

            $this->board_model->set_posts($boardId);
            $this->load->view('board/success');

        }
        
    }

    public function view()
    {
        $boardId = $this->uri->segment(3);
        $data['post'] = $this->board_model->get_post($boardId);
        $this->load->view('board/view', $data);
    }

    public function update()
    {
        // 기존의 정보들을 가져와서 화면에 나타나도록 한다.
        $boardId = $this->uri->segment(3);
        $data['post'] = $this->board_model->get_post($boardId);
        
        $this->load->view('board/update', $data);
    }

    public function delete($boardId)
    {
        $this->load->helper('url');

        $this->board_model->delete($boardId);
        redirect('board');
    }
}