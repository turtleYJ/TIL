<?php
class Test extends CI_Controller {

        public function Test(){
            parent::__construct();
        }
        

        public function template(){
            $this->load->view('index.php');
        }

}
?>