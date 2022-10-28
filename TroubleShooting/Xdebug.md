# xdebug breakpoint not working vscode
상황 : 설정을 제대로 했음에도 불구하고 xdebug의 모드가 debug로 안 바뀌는 현상. / 디버깅시 breakpoint에 걸리지 않는 현상.

처치 : /usr/lib/php/20190902 디렉토리 아래있는 xdebug.so 파일을 교체함.

    xdebug코어 파일인 xdebug.so에 문제가 있는 상황이었음. 이 파일을 교체해 주니 문제가 해결됨.