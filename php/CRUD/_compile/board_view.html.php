<?php /* Template_ 2.2.8 2022/10/13 08:11:33 /Users/dev1/Desktop/TIL/php/CRUD/_template/board_view.html 000001340 */ 
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
    
    <button onclick="location.href='/board/update/<?php echo $TPL_V1["id"]?>'">수정</button>
    <button onclick="del(<?php echo $TPL_V1["id"]?>);">삭제</button>
<?php }}?>
</body>
</html>

<script>
    function del(id) {
        if (confirm("정말 삭제하시겠습니까?"))
        {
            console.log("delete");
            location.href = '/board/delete/' + id;
        }
    }
    
    // Jquery 문법이라 사용 불가 (라이브러리 추가해줘야 함.)
    // $("#del").on("click", function(){
    //     if(window.confirm("정말 삭제하시곘습니까?")){
    //         console.log("확인");
    //     }
    // });
</script>