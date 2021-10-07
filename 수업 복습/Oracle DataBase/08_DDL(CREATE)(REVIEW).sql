-- DDL(CREATE) 복습
/*
    <DDL(Data Definition Language)>
        데이터 정의 언어로 오라클에서 제공하는 객체를 만들고(CREATE), 변경하고(ALTER), 삭제하는(DROP) 등
        실제 데이터 값이 아닌 데이터의 구조 자체를 정의하는 언어로 DB관리자, 설계자가 주로 사용한다.
        
        * 오라클에서의 객체 : 테이블, 뷰, 시퀀스, 인데스, 트리커, 프로시져, 함수, 동의어, 사용자 등등
*/
-- 회원에 대한 데이터를 담을 수 있는 MEMBER 테이블 생성

DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    ID VARCHAR2(20),
    PWD VARCHAR2(20),
    NAME VARCHAR2(20),
    MEMBER_DATE DATE DEFAULT SYSDATE
);

DESC MEMBER;

/*
    <컬럼에 주석 달기>
        [표현법]
            COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
*/
COMMENT ON COLUMN MEMBER.ID IS '회원아이디';
COMMENT ON COLUMN MEMBER.PWD IS '비밀번호';
COMMENT ON COLUMN MEMBER.NAME IS '회원이름';
COMMENT ON COLUMN MEMBER.MEMBER_DATE IS '가입날짜';

/*
    데이터 딕셔너리
        자원을 효율적으로 관리하기 위한 다양한 객체들의 정보를 저장하는 시스템 테이블이다.
        사용자가 객체를 생성하거나 객체를 변경하는 등의 작업을 할 떄 데이터베이스에 의해서 자동으로 갱신되는 테이블이다.
        데이터에 관한 데이터가 저장되어 있다고 해서 메타 데이터라고도 한다.
        
        USER_TABLES : 사용자가 가지고 있는 테이블들의 전반적인 구조를 확인하는 뷰 테이블이다.
        USER_TAB_COLUMN : 테이블, 뷰의 컬럼과 관련된 정보를 조회하는 뷰 테이블이다.
*/
SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'MEMBER';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'MEMBER';

-- 테이블에 샘플 데이터 추가(INSERT)
-- INSERT INTO 테이블명 VALUES
INSERT INTO MEMBER VALUES('USER1', '1234', '홍길동', '20211007');
INSERT INTO MEMBER VALUES('USER2', '1234', '정유일', DEFAULT);
INSERT INTO MEMBER VALUES('USER2', '1234', '정유일', SYSDATE);
INSERT INTO MEMBER(ID, PWD, NAME, MEMBER_DATE) VALUES('USER4', '1234', '이환진', SYSDATE);
INSERT INTO MEMBER(ID, PWD, NAME) VALUES('USER4', '1234', '이환진');

SELECT * FROM MEMBER;

COMMIT;

DROP TABLE MEMBER;

------------------------------------------------------
/* 
    <제약 조건(CONSTRAINTS)>
        사용자가 원하는 조건의 데이터만 유지하기 위해서 테이블 작성 시 각 컬럼에 대해 저장될 값에 대한 제약조건을 설정할 수 있다.
        제약 조건은 데이터 무결성 보장을 목적으로 한다.(데이터의 정확성과 일관성을 유지시키는 것.)

        * 종류 : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY


*/
-- 제약조건 확인
DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS; -- 사용자가 작성한 제약조건을 확인하는 뷰

DESC USER_CONS_COLUMNS;
SELECT * FROM USER_CONS_COLUMNS;

/*
    <NOT NULL 제약조건>
        해당 컬럼에 반드시 값이 있어야만 하는 경우 사용한다.
        삽입 / 수정 시 NULL 값을 허용하지 않도록 제안한다.
*/
-- 기존 MEMBER 테이블은 값에 NULL 이 있어도 삽인 가능하다.
INSERT INTO MEMBER VALUES(NULL, NULL, NULL, NULL);

SELECT * FROM MEMBER;

-- NOT NULL 제약조건을 설정한 테이블 만들기
-- NOT NULL 제약조건은 컬럼 레벨에서만 설정이 가능하다.

DROP TABLE MEMBER;

CREATE TABLE MEMBER(
    ID VARCHAR2(20) NOT NULL,
    PWD VARCHAR2(20) NOT NULL,
    NAME VARCHAR2(20) NOT NULL,
    MEMBER_DATE DATE DEFAULT SYSDATE
);

-- NOT NULL 제약 조건에 위배되어 오류 발생
INSERT INTO MEMBER VALUES(NULL, NULL, NULL, NULL);

-- NOT NULL 제약 조건이 걸려있는 컬럼에는 반드시 값이 있어야 한다.
INSERT INTO MEMBER VALUES('USER2', '1234', '길동이', DEFAULT);

DESC MEMBER;
SELECT * FROM MEMBER;


















