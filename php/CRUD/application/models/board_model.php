<?php

class Board_model extends CI_Model {

    public function __construct()
    {
        $this->load->database();
    }

    public function get_posts()
    {
        $query = $this->db->get('YJtest_board');
        return $query->result_array();
    }
}