/*
    <DML(Data Manupulation Language)>
        데이터 조작 언어로 테이블에 값을 삽입(INSERT)하거나, 수정(UPDATE), 삭제(DELETE)하는 구문이다.
        
    <INSERT>
        테이블에 새로운 행을 추가하는 구문이다.
        
        [표현법]
            1) INSERT INTO 테이블명 VALUES(값, 값, 값, ..., 값);
                테이블에 모든 컬럼에 값을 INSERT하고자 할 떄 사용한다.
                컬럼 순번을 지켜서 VALUES에 값을 나열해야 한다.
            2) INSERT INTO 테이블명(컬럼명, 컬럼명, ..., 컬럼명) VALUES(값, 값, ..., 값);
                테이블에 내가 선택한 컬럼에 대한 값만 INSERT 하고자 할 때 사용한다.
                선택이 안된 컬럼들은 기본적으로 NULL 값이 들어간다. (NOT NULL 제약조건이 걸려있는 컬럼은 반드시 선택해서 값을 제시해야 한다.)
                단, 기본값(DEFAULT)이 지정되어 있으면 NULL이 아닌 기본값이 들어간다.
            3) INSERT INTO 테이블명 (서브 쿼리);
                VALUES를 대신해서 서브 쿼리로 조회한 결과값을 통채로 INSERT 한다.(즉, 여러행을 INSERT 시킬 수 있다.)
                서브 쿼리의 결과값이 INSERT 문에 지정된 컬럼의 개수와 데이터 타입이 같아야 한다.
*/
-- 표현법 1)번 사용


-- 표현법 2) 번 사용




-- 표현법 3) 번 사용
-- 새로운 테이블 생성

CREATE TABLE EMP_01(
    EMP_ID      NUMBER,
    EMP_NAME    VARCHAR2(30),
    DEPT_TITLE  VARCHAR2(35)
);

INSERT INTO EMP_01(
    SELECT EMP_ID, EMP_NAME, EMP_TITLE
    FROM EMPLOYEE E
    LEFT OUTER JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
)

/*
    <INSERT ALL>
        두 개 이상의 테이블에 INSERT 하는데 동일한 서브 쿼리가 사용되는 경우
        INSERT ALL을 이용해서 여러 테이블에 한 번에 데이터 삽입이 가능하다.
        
        [표현법]
            1) INSERT ALL
               INTO 테이블1 [(컬럼, 컬럼, ...)] VALUES(값, 값, ...)
               INTO 테이블2 [(컬럼, 컬럼, 컬럼, ...)] VALUES(값, 값, 값, ...)
                    서브 쿼리;
                    
            2) INSERT ALL
               WHEN 조건 1 THEN
                    INTO 테이블1 [(컬럼, 컬럼, ...)] VALUES(값, 값, ...)
               WHEN 조건 2 THEN
                    INTO 테이블2 [(컬럼, 컬럼, 컬럼, ...)] VALUES(값, 값, 값, ...)
               서브 쿼리;     
*/
-- 표현법 1)번을 테스트할 테이블 만들기(테이블 구조만 복사)
CREATE TABLE EMP_DEPT
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
   FROM EMPLOYEE
   WHERE 1 = 0;
   
DROP TABLE EMP_DEPT;

CREATE TABLE EMP_DEPT
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
   FROM EMPLOYEE
   WHERE 1 = 0;

SELECT * FROM EMP_DEPT;

DROP TABLE EMP_MANAGER;


CREATE TABLE EMP_MANAGER
AS SELECT EMP_ID, EMP_NAME, MANAGER_ID
   FROM EMPLOYEE
   WHERE 1 = 0;

SELECT * FROM EMP_MANAGER;

-- EMP_DEPT 테이블에 EMPLOYEE테이블의 부서 코드가 D1인 직원의 사번, 이름, 부서코드, 입사일을
-- EMP_MANAGER 테이블에 EMPLOYEE테이블의 부서 코드가 D1인 직원 사번, 이름 관리자 사번을 조회하여 삽입한다.

INSERT ALL
INTO EMP_DEPT VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
    SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
    FROM EMPLOYEE
    WHERE DEPT_CODE = 'D1';
    
SELECT * FROM EMP_DEPT;
SELECT * FROM EMP_MANAGER;

DROP TABLE EMP_DEPT;
DROP TABLE EMP_MANAGER;

-- 표현법 2)번을 테스트할 테이블 만들기(테이블 구조만 복사)
CREATE TABLE EMP_OLD
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
   FROM EMPLOYEE
   WHERE 1 = 0;
   
CREATE TABLE EMP_NEW
AS SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
   FROM EMPLOYEE
   WHERE 1 = 0;
   
-- EMPLOYEE 테이블의 입사일 기준으로 2000년 1월 1일 이전에 입사한 사원의 정보는 .EMP_OLD테이블에 저장하고
-- 2000년 1월 1일 이후에 입사한 사원의 정보는 EMP_NEW테이블에 삽입한다.
SELECT * FROM EMPLOYEE;

INSERT ALL
WHEN HIRE_DATE < '00/01/01' THEN
    INTO EMP_OLD VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
WHEN HIRE_DATE >= '00/01/01' THEN
    INTO EMP_NEW VALUES(EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE;

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

DROP TABLE EMP_OLD;
DROP TABLE EMP_NEW;

-------------------------------------------------------------------------------------------------------------
UPDATE

























