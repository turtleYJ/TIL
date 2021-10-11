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
INSERT INTO EMPLOYEE
VALUES(999

;

SELECT * FROM EMPLOYEE;

DELETE 



































