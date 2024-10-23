# php에서 array는 순서가 있는 map과 같다.

#Example #1 A simple array
<?php
$array = array(
    "foo" => "bar",
    "bar" => "foo",
);

// Using the short array syntax
$array = [
    "foo" => "bar",
    "bar" => "foo",
];
?>

# Example #2 Type Casting and Overwriting example
# 모두 똑같은 정수 1이 인덱스 값이 된다. 따라서 마지막이 초기화된 값인 "d"가 value로 저장된다.
<?php 
$array = array(
    1       =>   "a",
    "1"     =>   "b",
    1.5     =>   "c",
    true    =>   "d",
);
var_dump($array);
?>

# Example #3 Mixed int and string keys
<?php 
$array = array(
    "foo"   =>  "bar",
    "bar"   =>  "foo",
    100     =>  -100,
    -100    =>  100,
);
var_dump($array);
?>

# Example #4 Indexed arrays without key
# key값을 지정해주지 않으면 index 0부터 시작해서 자동으로 생성되어 주입된다.
<?php
$array = array("foo", "bar", "hello", "world");
var_dump($array);
?>

# Example #5 Keys not on all elements
# 특정 키만을 키값을 지정할 수 있다.
# 이렇게하면 가장 큰 키값(6) 다음부터 어레이가 채워진다.
<?php 
$array = array(
            "a",
            "b",
    6   =>  "c",
    3   =>  "d",
            "e",
);
var_dump($array);
?>

# Example #6 Complex Type Casting and Overwriting example
<?php
$array = array(
    1       =>      'a',
    '1'     =>      'b',
    1.5     =>      'c',
    -1      =>      'd',
    '01'    =>      'e',
    '1.5'   =>      'f',
    true    =>      'g',
    false   =>      'h',
    ''      =>      'i',
    null    =>      'j',
    'k',
    2       =>      'l',
);
var_dump($array);
?>

# Example #7 Accessing array elements
<?php
$array = array(
    "foo"   =>  'bar',
    42      =>  24,
    "multi" => array(
        "dimensional"   => array(
            "array"     =>  "foo"
        )
    )
);
var_dump($array["foo"]);
var_dump($array[42]);
var_dump($array["multi"]["dimensional"]["array"]);
?>

# Example #8 Array dereferencing
<?php
function getArray() {
    return array(1, 2, 3);
}

var_dump(getArray()[1]);
?>

<?php
$arr = array(5 => 1, 12 => 2);

$arr[] = 56; // This is the same as $arr[13] = 56;
             // at this point of the script

$arr["x"] = 42; // This adds a new element to
                // the array with key "x"

unset($arr[5]); // This removes the element from the array
unset($arr); // This deletes the whole array
?>

<?php
$array = array(1, 2, 3, 4, 5);
print_r($array);

foreach ($array as $i => $value) {
    unset($array[$i]);
}
print_r($array);

// Append an item (note that the new key is 5, instead of 0)
$array[] = 6;
print_r($array);

// Re-index: (array_values)
$array = array_values($array);
print_r($array);
$array[] = 7;
print_r($array);
?>

<?php
$source_array = ['foo', 'bar', 'baz'];
print_r($source_array);

[$foo, $bar, $baz] =  $source_array;
print_r($source_array);

echo $foo;
echo $bar;
echo $baz;
?>

>> 이후에 필요하면 더 실습할 것.