<?php /* Template_ 2.2.8 2022/10/12 08:28:29 /Users/dev1/Desktop/TIL/php/CRUD/_template/board_view.html 000000799 */ 
$TPL_post_1=empty($TPL_VAR["post"])||!is_array($TPL_VAR["post"])?0:count($TPL_VAR["post"]);?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php if($TPL_post_1){foreach($TPL_VAR["post"] as $TPL_V1){?>
    <?php echo $TPL_V1["title"]?> <br>
    <?php echo $TPL_V1["writer"]?> <br>
    <?php echo $TPL_V1["text"]?> <br>
    <?php echo $TPL_V1["postdate"]?> <br>
<?php }}?>

    <button onclick="location.href='/board/update'">수정</button>
    <button>삭제</button>
</body>
</html>