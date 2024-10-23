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
                      <?php foreach ($postA as $post_item): ?>
                        <tr>
                            <td>
                              <a href="/bbs/board/view/22987?wr_id=4591894" class="ellipsis" style="height: 28px; width: 185px; max-width: 185px;"><span>2022년 10월 04일 인사발령 (입사)</span></a>
                              <div name="helpImg">
                                <div>
                                  <span class="mdi mdi-alpha-n-box mdi-16 mdi-orange"></span>
                                </div>
                              </div>
                            </td>
                            <td>								<a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">하민주</a>
                            </td>
                            <td><span class="txtSet fr m-right15">22.10.07</span></td>
                          </tr>
                        <?php echo $post_item['title']; ?><pre /><?php echo $post_item['writer']; ?><pre /><?php echo $post_item['postdate']; ?>
                        <?php endforeach; ?>
                      </tbody>
                    </table>



                  </article>
                  <article class="dragbox">
                    <h1>
                      <div><span>사내뉴스레터</span></div>
                    </h1>
                    <?php foreach ($postB as $post_item): ?>
                      <?php echo $post_item['title']; ?><pre /><?php echo $post_item['writer']; ?><pre /><?php echo $post_item['postdate']; ?>

                    <?php endforeach; ?>
                  </article>

                </section>
                <section class="rightBoard drag_column ui-sortable" id="rightboard">
                  <article class="dragbox">
                    <h1>
                      <div><span>정보보안 뉴스</span></div>
                    </h1>
                    <?php foreach ($postC as $post_item): ?>
                      <?php echo $post_item['title']; ?><pre /><?php echo $post_item['writer']; ?><pre /><?php echo $post_item['postdate']; ?>

                    <?php endforeach; ?>
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



<table cellpadding="0" cellspacing="0" summary="제목, 작성자, 작성시간" class="dragbox-content">
						<caption class="visibility">게시판 목록</caption>
						<colgroup>
							<col width="*"><col width="20%"><col width="10%">
						</colgroup>
						<thead class="visibility">
							<tr class="visibility">
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">작성시간</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<a href="/bbs/board/view/22987?wr_id=4591894" class="ellipsis" style="height: 28px; width: 185px; max-width: 185px;"><span>2022년 10월 04일 인사발령 (입사)</span></a>
									<div name="helpImg">
										<div>
											<span class="mdi mdi-alpha-n-box mdi-16 mdi-orange"></span>
										</div>
									</div>
								</td>
								<td>								<a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">하민주</a>
</td>
								<td><span class="txtSet fr m-right15">22.10.07</span></td>
							</tr>
							<tr>
								<td>
									<a href="/bbs/board/view/22987?wr_id=1297633" class="ellipsis" style="height: 28px; width: auto; max-width: 207px;"><span>2022년 9월 19일 인사발령 (입사)</span></a>
									<div name="helpImg">
									</div>
								</td>
								<td>								<a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">하민주</a>
</td>
								<td><span class="txtSet fr m-right15">22.09.22</span></td>
							</tr>
							<tr>
								<td>
									<a href="/bbs/board/view/22987?wr_id=1297632" class="ellipsis" style="height: 28px; width: 207px; max-width: 207px;"><span>2022년 9월 14일 인사발령 (입사 등)</span></a>
									<div name="helpImg">
									</div>
								</td>
								<td>								<a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">하민주</a>
</td>
								<td><span class="txtSet fr m-right15">22.09.22</span></td>
							</tr>
							<tr>
								<td>
									<a href="/bbs/board/view/22987?wr_id=1297631" class="ellipsis" style="height: 28px; width: 207px; max-width: 207px;"><span>노사협의회 정기회의 실시 안내 (3분기)</span></a>
									<div name="helpImg">
									</div>
								</td>
								<td>								<a href="/webmail/write?mails=&quot;%EC%96%91%EB%8F%99%EC%98%81&quot; <ydy0312@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">양동영</a>
</td>
								<td><span class="txtSet fr m-right15">22.09.15</span></td>
							</tr>
							<tr>
								<td>
									<a href="/bbs/board/view/22987?wr_id=1297630" class="ellipsis" style="height: 28px; width: 207px; max-width: 207px;"><span>9월 6일(화) 출근시간 변경안내 (10시 출근)</span></a>
									<div name="helpImg">
									</div>
								</td>
								<td>								<a href="/webmail/write?mails=&quot;%EC%96%91%EB%8F%99%EC%98%81&quot; <ydy0312@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">양동영</a>
</td>
								<td><span class="txtSet fr m-right15">22.09.05</span></td>
							</tr>
							<tr>
								<td>
									<a href="/bbs/board/view/22987?wr_id=1297629" class="ellipsis" style="height: 28px; width: auto; max-width: 207px;"><span>2022년 9월 1일 인사발령 (임명 등)</span></a>
									<div name="helpImg">
									</div>
								</td>
								<td>								<a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">하민주</a>
</td>
								<td><span class="txtSet fr m-right15">22.09.02</span></td>
							</tr>
							<tr>
								<td>
									<a href="/bbs/board/view/22987?wr_id=1297628" class="ellipsis" style="height: 28px; width: auto; max-width: 207px;"><span>사내 취업규칙 개정 공지</span></a>
									<div name="helpImg">
									</div>
								</td>
								<td>								<a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">하민주</a>
</td>
								<td><span class="txtSet fr m-right15">22.08.22</span></td>
							</tr>
							<tr>
								<td>
									<a href="/bbs/board/view/22987?wr_id=1297627" class="ellipsis" style="height: 28px; width: auto; max-width: 207px;"><span>2022년 8월 16일 인사발령 (퇴사)</span></a>
									<div name="helpImg">
									</div>
								</td>
								<td>								<a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">하민주</a>
</td>
								<td><span class="txtSet fr m-right15">22.08.18</span></td>
							</tr>
							<tr>
								<td>
									<a href="/bbs/board/view/22987?wr_id=1297625" class="ellipsis" style="height: 28px; width: auto; max-width: 207px;"><span>사무실 청소 변경 안내 (외주)</span></a>
									<div name="helpImg">
									</div>
								</td>
								<td>								<a href="/webmail/write?mails=&quot;%EC%96%91%EB%8F%99%EC%98%81&quot; <ydy0312@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">양동영</a>
</td>
								<td><span class="txtSet fr m-right15">22.08.08</span></td>
							</tr>
							<tr>
								<td>
									<a href="/bbs/board/view/22987?wr_id=1297624" class="ellipsis" style="height: 28px; width: 207px; max-width: 207px;"><span>2022년 08월 01일 인사발령 (입사 등)</span></a>
									<div name="helpImg">
									</div>
								</td>
								<td>								<a href="/webmail/write?mails=&quot;%ED%95%98%EB%AF%BC%EC%A3%BC&quot; <linuxhmj@mailplug.co.kr>" class="ellipsis" style="height: 28px; width: 35px; max-width: 35px;">하민주</a>
</td>
								<td><span class="txtSet fr m-right15">22.08.04</span></td>
							</tr>
						</tbody>
					</table>