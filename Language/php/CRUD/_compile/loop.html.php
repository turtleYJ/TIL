<?php /* Template_ 2.2.8 2022/10/12 01:06:58 /Users/dev1/Desktop/TIL/php/CRUD/_template/loop.html 000000509 */ 
$TPL_row_1=empty($TPL_VAR["row"])||!is_array($TPL_VAR["row"])?0:count($TPL_VAR["row"]);?>
<table>
    <tr><td colspan=2> <?php echo $TPL_VAR["title"]?> </td></tr>
    <tr><td> exponent </td><td> 2^exponent </td></tr>
<?php if($TPL_row_1){foreach($TPL_VAR["row"] as $TPL_V1){?>
    <tr><td> <?php echo $TPL_V1["exponent"]?> </td><td> <?php echo $TPL_V1["power"]?> </td></tr>
<?php }}?>
    </table>