<?php echo validation_errors(); ?>

<?php echo form_open('board/write'); ?>

    <input type="submit" name="submit" value="등록" />
    <button type="button" name="btn_cancel" id="btn_cancel_s" class="button small white"><span>취소</span></button>

    <br><br>

    <label for="text">게시판</label>
    <select name="board_select" id="board_select" tabindex="-1" class="select2-hidden-accessible" aria-hidden="true">
        <option value="no_data" selected="selected">게시판 선택</option>
        <option value="a">공지사항</option>
        <option value="b">정보보안 뉴스</option>
        <option value="c">사내뉴스레터</option>
    </select>

    <br><br>

    <label for="title">제목</label>
    <input type="text" name="title" /><br />

    <br>

    <label for="text">본문</label>
    <textarea name="text"></textarea><br />
</form>

<!-- <script>
// 취소 버튼
// 코드 분속할 것.
$("button[name^='btn_cancel']").on('click', function(e) {
    var url = "",
        page = "lists",
        wr_id = '{wr_id}';

    if (wr_id != '0') {
        page = "view";
    }
    var test = '';
    {? bo_table == '000000'}
        {? board_select.boarddbs == ''}
            url = "{url_path}/board/main";
        {:}
            url = "{url_path}/board/" + page + "/{= str_replace('.dbs','',board_select.boarddbs)}";
        {/}
    {:}
        url = "{url_path}/board/" + page + "/{bo_table}?{= query_string('type')}";
    {/}
        document.location.href = url;
});

</script> -->



