/*
    <DDL(Data Definition Language))>
        데이터 정의 언어로 오라클에서 제공하는 객체를 만들고(CREATE), 변경하고(ALTER), 삭제하는(DROP) 등
        실제 데이터 값이 아닌 데이터의 구조 자체를 정의하는 언어로 DB 관리자, 설계자가 주로 사용한다.
        
    <ALTER>
        오라클에서 제공하는 객체를 수정하는 구문이다.
        
    <테이블 수정>
        [표현법]
            ALTER TABLE 테이블명 수정할 내용;
            
        * 수정할 내용
            1) 컬럼 추가/수정/삭제
            2) 제약조건 추가/삭제 --> 수정은 불가능(삭제한 후 새로 추가해야 한다.)
            3) 테이블명/컬럼명/제약조건명 변경
*/

DROP TABLE DEPT_COPY;

-- 실습에 사용할 테이블 생성
CREATE TABLE DEPT_COPY
AS SELECT *
    FROM DEPARTMENT;
    
SELECT * FROM DEPT_COPY;

-- 1) 컬럼 추가/수정/삭제
--  1-1) 컬럼 추가(ADD) : ALTER TABLE 테이블명 ADD 컬럼명 데이터타입 [DEFAULT 기본값]
-- CNAME 컬럼을 맨 뒤에 추가한다.
-- 기본값을 지정하지 않으면 새로 추가된 컬럼은 NULL 값으로 채워진다.
ALTER TABLE DEPT_COPY ADD CNAME VARCHAR2(20);

-- LNMAE 컬럼을 기본값을 지정한 채로 추가
ALTER TABLE DEPT_COPY ADD LNAME VARCHAR2(40) DEFAULT '한국';

-- 1-2) 컬럼 수정(MODIFY)
--      데이터 타입 변경 : ALTER TABEL 테이블명 MODIFY 컬럼명 변경할 데이터타입
--      기본값 변경     : ALTER TABLE 테이블명 MODIFY 컬럼명 DEFAULT 변경할 기본값
-- DEPT_ID 컬럼의 데이터 타입을 CHAR(3)으로 변경
ALTER TABLE DEPT_COPY MODIFY DEPT_ID CHAR(3);
-- ALTER TABLE DEPT_COPY MODIFY DEPT_ID CHAR(2);
-- ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE VARCHAR2(10);
ALTER TABLE DEPT_COPY MODIFY DEPT_ID NUMBER; 

-- 다중 수정
-- DEPT_TITLE 컬럼의 데이터 타입을 VARCHAR2(40),
-- LOCATION_ID 컬럼의 데이터 타입을 VARCHAR2(2),
-- LNAME 컬럼의 기본값을 미국으로 변경하기
ALTER TABLE DEPT_COPY 
MODIFY DEPT_TITLE VARCHAR2(40)
MODIFY LOCATION_ID VARCHAR2(2)
MODIFY LNAME DEFAULT '미국';

-- 1-3) 컬럼 삭제(DROP COLUMN) : ALTER TABLE 테이블명 DROP COLUMN 컬럼명
--      데이터 값이 기록되어 있어도 같이 삭제된다. (단, 삭제된 컬럼 복구는 불가능)
--      테이블에는 최소 한 개의 컬럼은 존재해야 한다.
--      참조되고 있는 컬럼이 있다면 삭제가 불가능하다.

-- DEPT_ID 컬럼 지우기
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_ID;

SELECT * FROM DEPT_COPY;

ROLLBACK; -- DDL구문은 복구 불가능

ALTER TABLE DEPT_COPY DROP COLUMN DEPT_TITLE;
ALTER TABLE DEPT_COPY DROP COLUMN LOCATION_ID;
ALTER TABLE DEPT_COPY DROP COLUMN CNAME;
ALTER TABLE DEPT_COPY DROP COLUMN LNAME;

----------------------------------------------------------------------
-- 2) 제약조건 추가/삭제
-- 2-1) 제약조건 추가
--      PRIMARY KEY : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] PRIMARY KEY(컬럼명);
--      FORIEGN KEY : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] FORIEGN KEY(컬럼명) REFERENCES 테이블명 [(컬럼명)];
--      UNIQUE      : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] UNIQUE(컬럼명);
--      CHECK       : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] CHECK(컬럼에 대한 조건);
--      NOT NULL    :  ALTER TABLE 테이블명 MODIFY 컬럼명 [CONSTRAINT 제약조건명] NOT NULL;

-- 실습에 사용할 테이블 생성
DROP TABLE DEPT_COPY;

CREATE TABLE DEPT_COPY
AS SELECT *
   FROM DEPARTMENT;
   
-- DEPT_COPY 테이블에
-- DEPT_ID는 PK 제약조건 추가
-- DEPT_TITLE은 UNIQUE, NOT NULL 제약조건 추가
ALTER TABLE DEPT_COPY 
ADD CONSTRAINT DEPT_COPY_DEPT_ID_PK PRIMARY KEY(DEPT_ID)
ADD CONSTRAINT DEPT_COPY_DEPT_TITLE_UQ UNIQUE(DEPT_TITLE)
MODIFY DEPT_TITLE CONSTRAINT DEPT_COPY_DEPT_TITLE_NN NOT NULL;

SELECT * FROM DEPT_COPY;

-- EMPLOYEE 테이블 DEPT_CODE, JOB_CODE에 FOREIGN KEY 제약조건을 적용
ALTER TABLE EMPLOYEE ADD CONSTRAINT EMPLOYEE_DEPT_CODE FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT;
ALTER TABLE EMPLOYEE ADD CONSTRAINT EMPLOYEE_JOB_CODE에 FOREIGN KEY(JOB_CODE) REFERENCES JOB;

SELECT * FROM DEPARTMENT;

-- 2-2) 제약조건 삭제
--      NOT NULL : MODIFY 컬럼명 NULL
--      나머지    : DROP CONSTRAINT 제약조건명

-- DEPT_COPY_DEPT_ID_PK 제약조건 삭제
ALTER TABLE DEPT_COPY DROP CONSTRAINT DEPT_COPY_DEPT_ID_PK;

-- DEPT_COPY_DEPT_TITLE_UQ 제약조건,
-- DEPT_COPY_DEPT_TITLE_NN 제약삭제
ALTER TABLE DEPT_COPY 
DROP CONSTRAINT DEPT_COPY_DEPT_TITLE_UQ
MODIFY DEPT_TITLE NULL;

-- * 제약조건 수정은 불가능하다. 즉, 삭제 후 다시 제약 조건을 추가해야 한다.

-- 작성한 제약조건 확인
SELECT CONSTRAINT_NAME, 
       CONSTRAINT_TYPE, 
       UC.TABLE_NAME, 
       COLUMN_NAME
FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';


-- 3) 테이블명/컬럼명/제약조건명 변경
--  3-1) 컬럼명 변경     : ALTER TABLE 테이블명 RENAME COLUMN 기존컬럼명 TO 변경할 컬럼명
-- DEPT_COPY 테이블에 DEPT_TITLE 컬럼명을 DEPT_NAME로 변경
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

--  3-2) 제약조건명 변경  : ALTER TABLE 테이블명 RENAME CONSTRAINT 기존제약조건명 TO 변경할제약조건명



SELECT * FROM DEPT_COPY;
-- SYS_C007304 --> DEPT_COPY_DEPT_ID_NN
ALTER TABLE DEPT_COPY RENAME CONSTRAINT SYS_C007304 TO DEPT_COPY_DEPT_ID_NN;

--  3-3) 테이블명 변경
--      1) ALTER TABLE 테이블명 RENAME TO 변경할테이블명
--      2) RENAME 기존테이블명 TO 변경할테이블명
-- DEPT_COPY --> DEPT_TEST
ALTER TABLE DEPT_COPY RENAME TO DEPT_TEST;

RENAME DEPT_COPY TO DEPT_TEST;

DROP TABLE DEPT_TEST;

--------------------------------------------------------------------------
/*
    <DROP>
        데이터베이스 객체를 삭제하는 구문
*/

-- 테이블 삭제
DROP TABLE DEPT_TEST;

-- 단, 참조되고 있는 부모 테이블은 함부로 삭제가 되지 않는다.
-- 만약에 삭제하고자 한다면
-- 1) 자식 테이블 먼저 삭제한 후 부모테이블을 삭제하는 방법



























