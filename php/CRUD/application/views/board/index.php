<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <link rel = "stylesheet" type = "text/css" 
    href = "<?php echo base_url(); ?>css/css1.css">

    <title>My test page</title>
  </head>
  <body>
    <div id="wrapper">
        <div id="layout-static">
            <div class="static-sidebar skin_white" style="height: 929px;">
                <div class="button_menu">
                    <a href="/board/write/" class="button skin_bg04 single">
                            <span>글쓰기</span>
                    </a>
                </div>
            </div>

            <div class="static-content-wrapper">
                <?php foreach ($posts as $post_item): ?>
                    <?php echo $post_item['title']; ?><pre /><?php echo $post_item['writer']; ?><pre /><?php echo $post_item['postdate']; ?>

                <?php endforeach; ?>

            </div>
        </div>
    </div>
    

  </body>
</html>




