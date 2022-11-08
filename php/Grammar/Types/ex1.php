<?php
$a_bool = TRUE;
$a_str = "foo";
$astr2 = 'foo';
$an_int = 12;

echo gettype($a_bool);
echo gettype($a_str);

// If this is an integer, increment it by four
if (is_int($an_int)) {
    $an_int += 4;
}

echo $an_int;

// If $a_bool is a string, print it out
// (does not print out anything)
if (is_string($a_bool)) {
    echo "String: $a_bool";
}