<?php

class Board_model extends CI_Model {

    public function __construct()
    {
        $this->load->database();
    }

    // 모든 post를 다 뿌려주는 로직.
    public function get_posts($category = FALSE)
    {
        if ($category === FALSE)
        {
            $query = $this->db->get('YJtest_board');
            return $query->result_array();
        }

        $query = $this->db->get_where('YJtest_board', array('category' => $category));
        return $query->result_array();
    }

    public function set_posts()
    {
        $data = array(
            'title' => $this->input->post('title'),
            'text' => $this->input->post('text'),
            'category' => $this->input->post('board_select')
        );

        echo $data['category'];

        return $this->db->insert('YJtest_board', $data);
    }
