<?php
function test() {
    try {
        throw new Exception('foo');
    } catch (Exception $e) {
        return 'catch';
    } finally {
        return 'finally';
    }
}

echo test();

// return이 이전에 와도 finally는 반드시 지나쳐야 한다.