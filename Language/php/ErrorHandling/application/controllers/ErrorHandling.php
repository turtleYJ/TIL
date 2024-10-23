<?php
defined('BASEPATH') OR exit('No direct script access allowed');

function a_test($str)
{
	echo "\nHi: $str";
	var_dump(debug_backtrace());
}

a_test('friend');
?>

<?php