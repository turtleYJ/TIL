<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Calendar extends CI_Controller {

	public function index() {
        $this->load->library('calendar');

        echo $this->calendar->generate();
        echo $this->calendar->generate(2000, 6);

        $data = array(
            5  => 'http://example.com/news/article/2006/06/03/',
            7  => 'http://example.com/news/article/2006/06/07/',
            13 => 'http://example.com/news/article/2006/06/13/',
            26 => 'http://example.com/news/article/2006/06/26/'
        );

        echo $this->calendar->generate(2000, 6, $data);


        $prefs = array(
            'start_day'    => 'monday',
            'month_type'   => 'long',
            'day_type'     => 'short'
        );
        
        $this->load->library('calendar', $prefs);
        
        echo $this->calendar->generate();
    }

    public function link() {
        $prefs = array(
            'show_next_prev' => TRUE,
            // 'next_prev_url' => 'http://example.com/index.php/calendar/show/'
        );

        $this->load->library('calendar', $prefs);

        echo $this->calendar->generate($this->uri->segment(3), $this->uri->segment(4));
    }
}