<?php /* Template_ 2.2.8 2022/10/12 09:41:58 /Users/dev1/Desktop/TIL/php/CRUD/_template/board_index.html 000009265 */ 
$TPL_postA_item_1=empty($TPL_VAR["postA_item"])||!is_array($TPL_VAR["postA_item"])?0:count($TPL_VAR["postA_item"]);
$TPL_postB_item_1=empty($TPL_VAR["postB_item"])||!is_array($TPL_VAR["postB_item"])?0:count($TPL_VAR["postB_item"]);
$TPL_postC_item_1=empty($TPL_VAR["postC_item"])||!is_array($TPL_VAR["postC_item"])?0:count($TPL_VAR["postC_item"]);?>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <link rel = "stylesheet" type = "text/css" 
    href = "<?php echo base_url(); ?>css/css1.css">
    <script src="http://code.jquery.com/jquery-latest.js"></script> 

    <title>My test page</title>
  </head>
  <body>
    <div id="wrapper">
      <div id="layout-static">
          <div class="sidebar-wrapper first-load ui-resizable">
            <div class="static-sidebar skin_white" style="height: 929px;">
                <div class="button_menu">
                    <a href="/board/write/" class="button skin_bg04 single">
                            <span>글쓰기</span>
                    </a>
                </div>
            </div>
          </div>

          <div class="static-content-wrapper">
            <div id="header">
              <span class="title-page">즐겨찾는 게시판</span>
            </div>

            <div class="boardWrapper">
              <div class="top_box">
                <div class="pl div">
                  <button type="button" id="add_list" class="pl button white small">
                    <span>게시판 선택
                      <i class="mdi mdi-chevron-down mdi-16 mdi-500 dib" style="margin-left:8px;"></i>
                    </span>
                  </button>
                  <div id="quick_area" class="quick_area" style="display: none;">
                    <div class="add_list">
                      <div class="add_list_all">
                        <input id="all_select_board" type="checkbox" checked="checked"><label for="all_select_board">
                          <strong>전체 선택</strong>
                        </label>
                      </div>
                      <ul id="select_board"><li class="checked"><input type="checkbox" id="board_add_22987" value="22987" checked="checked"><label for="board_add_22987">공지사항</label></li><li class="checked"><input type="checkbox" id="board_add_22988" value="22988" checked="checked"><label for="board_add_22988">정보보안 뉴스</label></li><li class="checked"><input type="checkbox" id="board_add_22991" value="22991" checked="checked"><label for="board_add_22991">사내뉴스레터</label></li></ul>
                    </div>
                    <div class="bottom">
                      <a href="javascript:;" id="add_board_ok" class="button white small">
                        <span>확인</span>
                      </a>
                      <a href="javascript:close();" id="add_board_cancel" class="button white small" style="margin-left:2px;">
                        <span>취소</span>
                      </a>
                    </div>
				          </div>
                </div>
              </div>

              
              <div id="scroll_body_list" class="boardMain_list">
                <section class="leftBoard drag_column ui-sortable" id="leftBoard">
                    <article class="dragbox">
                        <h1>
                        <div><span>[공지] 공지사항</span></div>
                        </h1>

                        <table cellpadding="0" cellspacing="0" summary="제목, 작성자, 작성시간" class="dragbox-content">
                            <colgroup>
                                <col width="*"><col width="20%"><col width="10%">
                            </colgroup>
                            <tbody>
<?php if($TPL_postA_item_1){foreach($TPL_VAR["postA_item"] as $TPL_V1){?>
                                <tr>
                                    <td>
                                        <a href="/board/view/<?php echo $TPL_V1["id"]?>" class="ellipsis" style="height: 28px; width: 185px; max-width: 185px;"><span><?php echo $TPL_V1["title"]?></span></a>
                                        <div name="helpImg">
                                            <div>
                                                <span class="mdi mdi-alpha-n-box mdi-16 mdi-orange"></span>
                                            </div>
                                        </div>
                                    </td>
                                    <td>								
                                        <a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;"><?php echo $TPL_V1["writer"]?></a>
                                    </td>
                                    <td>
                                        <span class="txtSet fr m-right15"><?php echo $TPL_V1["postdate"]?></span>
                                    </td>
                                  </tr>
<?php }}?>
                            </tbody>
                        </table>



                    </article>
                    <article class="dragbox">
                        <h1>
                        <div><span>사내뉴스레터</span></div>
                        </h1>
                        <table cellpadding="0" cellspacing="0" summary="제목, 작성자, 작성시간" class="dragbox-content">
                          <colgroup>
                              <col width="*"><col width="20%"><col width="10%">
                          </colgroup>
                          <tbody>
<?php if($TPL_postB_item_1){foreach($TPL_VAR["postB_item"] as $TPL_V1){?>
                              <tr>
                                  <td>
                                      <a href="/bbs/board/view/22987?wr_id=4591894" class="ellipsis" style="height: 28px; width: 185px; max-width: 185px;"><span><?php echo $TPL_V1["title"]?></span></a>
                                      <div name="helpImg">
                                          <div>
                                              <span class="mdi mdi-alpha-n-box mdi-16 mdi-orange"></span>
                                          </div>
                                      </div>
                                  </td>
                                  <td>								
                                      <a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;"><?php echo $TPL_V1["writer"]?></a>
                                  </td>
                                  <td>
                                      <span class="txtSet fr m-right15"><?php echo $TPL_V1["postdate"]?></span>
                                  </td>
                                </tr>
<?php }}?>
                          </tbody>
                      </table>
                    </article>

                </section>
                <section class="rightBoard drag_column ui-sortable" id="rightboard">
                  <article class="dragbox">
                    <h1>
                      <div><span>정보보안 뉴스</span></div>
                    </h1>
                    <table cellpadding="0" cellspacing="0" summary="제목, 작성자, 작성시간" class="dragbox-content">
                      <colgroup>
                          <col width="*"><col width="20%"><col width="10%">
                      </colgroup>
                      <tbody>
<?php if($TPL_postC_item_1){foreach($TPL_VAR["postC_item"] as $TPL_V1){?>
                          <tr>
                              <td>
                                  <a href="/bbs/board/view/22987?wr_id=4591894" class="ellipsis" style="height: 28px; width: 185px; max-width: 185px;"><span><?php echo $TPL_V1["title"]?></span></a>
                                  <div name="helpImg">
                                      <div>
                                          <span class="mdi mdi-alpha-n-box mdi-16 mdi-orange"></span>
                                      </div>
                                  </div>
                              </td>
                              <td>								
                                  <a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;"><?php echo $TPL_V1["writer"]?></a>
                              </td>
                              <td>
                                  <span class="txtSet fr m-right15"><?php echo $TPL_V1["postdate"]?></span>
                              </td>
                            </tr>
<?php }}?>
                      </tbody>
                  </table>
                  </article>
                </section>
              </div>


            </div>
          </div>
      </div>
    </div>
  </body>
</html>

<script>
  $("#add_list").on("click", function(){
					$("#quick_area").show();
  });

  function close() {
    $("#quick_area").hide();
  }

</script>