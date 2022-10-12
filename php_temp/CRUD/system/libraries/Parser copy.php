<?php  if ( ! defined('BASEPATH')) exit('No direct script access allowed');
/**
 *
 * Template Underscore Parser Class
 *
 * ����! �� Ŭ������ CI�ھ��� ParserŬ������ �����ε��մϴ�.
 *
 * @package		Application
 * @subpackage	Libraries
 * @category	Libraries
 * @author		������ <webmaster@isweety.com>
 * @link		http://isweety.com
 */

require_once 'Template_/Template_.class.php';

class CI_Parser extends Template_ {

	var $CI;

	/**
	 * Constructor
	 *
	 * @access	public
	 */
	function CI_Parser()
	{
		$this->CI = & get_instance();
		$this->initialize();

		log_message('debug', "Template Underscore Parser Class Initialized");
	}

	/**
	 * Initialize Preferences
	 *
	 * @access	public
	 */
	function initialize()
	{
		$this->compile_check	= TRUE;
		$this->compile_dir		= BASEPATH.'cache';
		$this->compile_ext		= 'php';
		$this->skin				= '';
		$this->notice			= FALSE;
		$this->path_digest		= FALSE;

		$this->template_dir		= APPPATH.'views';
		$this->prefilter		= '';
		$this->postfilter		= '';
		$this->permission		= 0755;
		$this->safe_mode		= FALSE;
		$this->auto_constant	= FALSE;

		$this->caching			= TRUE;
		$this->cache_dir		= BASEPATH.'cache';
		$this->cache_expire		= 3600;

		$this->scp_				= '';
		$this->var_				= array(''=>array());
		$this->obj_				= array();
	}

	/**
	 * Template Parsing
	 *
	 * @access	public
	 * @param	string
	 * @return	void
	 */
	function parse($fid)
	{
		$this->CI->output->append_output($this->fetch($fid));
	}

}

/* End of file Parser.php */
/* Location: ./system/application/libraries/Parser.php */