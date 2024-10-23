# Example #1 Advanced escaping using conditions
# 조건에 따라 출력할지 경정하는 방법.
# php태그 바깥에 있어도 조건에 맞다면 그 사이값이 출력된다.

<?php if ($expression == true): ?>
    This will show if the expression is true.
<?php else: ?>
    Otherwise this will show.
<?php endif; ?>