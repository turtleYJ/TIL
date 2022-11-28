# Example #1 Created as a result of typecasting to object
# 객체를 인스턴스화 할때 stdClass가 생성되는 경우
<?php
$obj = (object) array('foo' => 'bar');
var_dump($obj);
?>

<?php 
$json = '{"foo":"bar"}';
var_dump(json_decode($json));
?>

<?php
$obj = new stdClass();
$obj->
?>