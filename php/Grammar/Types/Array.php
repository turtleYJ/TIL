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