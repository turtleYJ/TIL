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

DECLARE
    EID     NUMBER;
    ENAME   VARCHAR2(30);
    PI      CONSTANT NUMBER := 3.14;
BEGIN
    EID := 888;
    ENAME := '배장남';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/

/*
    1-2) 레퍼런스 타입 변수 선언 및 초기화
        [표현법]
            변수명 테이블명.컬럼명%TYPE;
            
        - 해당하는 테이블의 컬럼에 데이터 타입을 참조해서 그 타입으로 변수를 지정한다.    
*/

-- 사원명을 입력받아서 사원의 사번, 사원명, 급여정보를 각각 EID, ENAME, SAL 변수에 대입 후 출력한다.
DECLARE 
    EID     EMPLOYEE.EMP_ID%TYPE;
    ENAME   EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY
    INTO EID, ENAME, SAL
    FROM EMPLOYEE
    WHERE EMP_NAME = '&사원명';
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || TO_CHAR(SAL, 'FM999,999,999') || '원');
END;
/


-------------------------------- 실습 문제 --------------------------------
-- 레퍼런스 타입 변수로 EID, ENAME, JCODE, DTITLE, SAL를 선언하고 
-- 각 자료형은 EMPLOYEE 테이블의 EMP_ID, EMP_NAME, JOB_CODE, SALARY 컬럼의 타입과
-- DEPARTMENT 테이블의 DEPT_TITLE 컬럼의 타입을 참조한다.
-- 사용자가 입력한 사번과 일치하는 사원을 조회(사번, 사원명, 직급 코드, 부서명, 급여)한 후 조회 결과를 각 변수에 대입 후 출력한다.

SELECT E.EMP_ID, E.EMP_NAME, E.JOB_CODE, D.DEPT_TITLE, E.SALARY
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
WHERE EMP_ID = '&사번';


DECLARE
    EID         EMPLOYEE.EMP_ID%TYPE;
    ENAME       EMPLOYEE.EMP_NAME%TYPE;
    JCODE       EMPLOYEE.JOB_CODE%TYPE;
    DTITLE      DEPARTMENT.DEPT_TITLE%TYPE;
    SAL         EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT E.EMP_ID, E.EMP_NAME, E.JOB_CODE, D.DEPT_TITLE, E.SALARY
    INTO EID, ENAME, JCODE, DTITLE, SAL
    FROM EMPLOYEE E
    JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('JCODE : ' || JCODE);
    DBMS_OUTPUT.PUT_LINE('DTITLE : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
END;
/
/*
    1-3) ROW 타입 변수 선언 및 초기화
        [표현법]
            변수명 테이블명%ROWTYPE;
        
        - 하나의 테이블의 여러 컬럼의 값을 한번에 저장할 수 있는 변수를 의미한다.
        - 모든 컬럼을 조회하는 경우에 사용하기 편리하다.
*/

DECLARE
    EMP EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EMP.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || EMP.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('JCODE : ' || EMP.JOB_CODE);
END;
/
--------------------------------------------------------------
/*
    2) 실행부(EXCUTABLE SECTION)
      2-1) 선택문(조건문)
        1) 단일 IF 구문
            [표현법]
                IF 조건식 THEN
                    실행 문장
                END IF;    
*/
-- 사번을 입력받은 후 해당 사원의 사번, 이름, 급여, 보너스를 출력
-- 단, 보너스를 받지 않는 사원은 보너스를 출력 전에 '보너스를 지급받지 않는 사원입니다.'라는 문구를 출력한다.

DECLARE
    EID     EMPLOYEE.EMP_ID%TYPE;
    ENAME   EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
    BONUS   EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, BONUS
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE    
    WHERE EMP_ID = '&사번';
    
    IF BONUS IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
        DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
        DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
        DBMS_OUTPUT.PUT_LINE('BONUS : ' || BONUS);
    END IF;
    
        
        
END;
/

/*
        2) IF ~ ELSE 구문
            [표현법]
                IF 조건식 THEN
                    실행 문장
                ELSE
                    실행 문장
                END IF;    
*/

-- 사번을 입력받아 해당 사원의 사번, 이름, 부서명, 국가 코드를 조회한 후 출력한다.
-- 단, 국가 코가코드가 'KO'이면 국내팀 그 외는 해외팀으로 출력한다. 
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;

SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, L.NATIONAL_CODE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
WHERE EMP_ID = '&사번';

DECLARE
    EID     EMPLOYEE.EMP_ID%TYPE;
    ENAME   EMPLOYEE.EMP_NAME%TYPE;
    DTITLE  DEPARTMENT.DEPT_TITLE%TYPE;
    NCODE   LOCATION.NATIONAL_CODE%TYPE;
BEGIN
    SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, L.NATIONAL_CODE
    INTO EID, ENAME, DTITLE, NCODE
    FROM EMPLOYEE E
    JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
    JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
    WHERE EMP_ID = '&사번';
    
    IF NCODE = 'KO' THEN
        DBMS_OUTPUT.PUT_LINE('국내팀');
    ELSE
        DBMS_OUTPUT.PUT_LINE('해외팀');
    END IF;
END;
/

/*
        2) IF ~ ELSIF ~ ELSE 구문
            [표현법]
                IF 조건식 THEN
                    실행 문장
                ELSIF 조건식 THEN
                    실행 문장
                ...    
                [ELSE
                    실행 문장]
                END IF;    
*/
-- 점수를 입력받아 SCORE 변수에 저장한 후 학점은 입력된 점수에 따라 GRADE 변수에 저장한다.
--   90점 이상은 'A'
--   80점 이상은 'B'
--   70점 이상은 'C'
--   60점 이상은 'D'
--   60점 미만은 'F'
-- 출력은 '당신의 점수는 95점이고, 학점은 A학점입니다.' 와 같이 출력한다.

DECLARE
    SCORE NUMBER;
    GRADE CHAR(1);
BEGIN
    SCORE := '&점수';
    
    IF SCORE >= 90 THEN
        GRADE := 'A';
    ELSIF SCORE >= 80 THEN
        GRADE := 'B'; 
    ELSIF SCORE >= 70 THEN
        GRADE := 'C';  
    ELSIF SCORE >= 60 THEN
        GRADE := 'D'; 
    ELSE
        GRADE := 'F'; 
    END IF;    
        
    DBMS_OUTPUT.PUT_LINE('당신의 점수는 ' || SCORE || '이고, 학점은 ' || GRADE || '학점입니다.');    
END;
/

DECLARE
    SAL EMPLOYEE.SALARY%TYPE;
    
BEGIN

END;
/




























































































