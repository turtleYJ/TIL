<?php

function a_test($str)
{
    echo "Hi: $str\n";
    var_dump(debug_backtrace());
}

a_test('friend');
?>