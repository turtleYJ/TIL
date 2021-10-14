/*
    <PL/SQL>
        오라클 자체에 내장되어 있는 절차적 언어로 SQL문장 내에서  변수의 정의, 조건 처리(IF), 반복 처리(LOOP, FOR, WHILE) 등을 지원한다.
        (다수의 SQL문을 한 번에 실행이 가능하다.)
        
        [PL/SQL의 구조]
            1) 선언부(DECLARE SECTION)         : DECLARE로 시작, 변수나 상수를 선언 및 초기화하는 부분이다.
            2) 실행부(EXECUTABLE SECTION)      : BEGIN으로 시작, SQL문, 제어문(조건, 반복) 등의 로직을 기술하는 부분이다.
            3) 예외 처리부(EXCEPTION SECTION)   : EXCEPTION로 시작, 예외 발생 시 해결하기 위한 구문을 기술하는 부분이다.
*/

SET SERVEROUTPUT ON;

BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE!!');
END;
/

/*
    1) 선언부 (DECLARE SECTION)
        변수 및 상수를 선언해 놓는 공간이다. (선언과 동시에 초기화도 가능)
        변수 및 상수는 일반 타입 변수, 레퍼런스 타입 변수, ROW타입 변수로 선언해서 사용할 수 있다.
        
      1-1) 일반 타입 변수 선언 및 초기화
        [표현법]
            변수명 [CONSTANT] 자료형(크기) [:= 값];
*/

