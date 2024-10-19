
# PL/SQL
    오라클 자체에 내장되어 있는 절차적 언어로 SQL문장 내에서 변수의 정의, 조건 처리(IF), 반복처리(LOOP, FOR, WHILE) 등을 지원한다.
    (다수의 SQL문을 한 번에 실행이 가능하다.)

## 구조
1. 선언부(DECLARE SECTION) : DECLARE로 시작, 변수나 상수를 선언 및 초기화하는 부분이다.
2. 실행부(EXECUTABLE SECTION) : BEGIN로 시작, SQL문, 제어문(조건, 반복문) 등의 로직을 기술하는 부분이다.
3. 예외 처리부(EXCEPTION SECTION) : EXCEPTION로 시작, 예외 발생 시 해결하기 위한 구문을 기술하는 부분이다.

<BR>

참고) PL/SQL 은 기본적으로 처리된 PL/SQL 문장의 결과를 화면에 출력하지 않는다. 
> SET SERVEROUTPUT ON; 

을 입력해 화면 출력기능을 활성화시켜야한다.