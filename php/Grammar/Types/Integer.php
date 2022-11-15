<h1>Integer overflow on a 64-bit system</h1>

<?php
$large_number = 9223372036854775807;
var_dump($large_number);

$large_number = 9223372036854775808;
var_dump($large_number);

$million = 1000000;
$large_number = 50000000000000 * $million;
var_dump($large_number);
?>

<?php
var_dump(25 / 7);
var_dump((int) (25 / 7));
var_dump((round(25 / 7)));
?>