
# 조인(JOIN)

> 여러 테이블에서 데이터를 조회하고자 할 때 사용되는 구문이다.  
> 각 테이블 간에 공통된 컬럼으로 데이터를 합쳐서 하나의 결과(RESULT SET)로 조회한다.

<BR>

## 1. 등가 조인(EQUAL JOIN) / 내부 조인(INNER JOIN)
> 연결시키는 컬럼의 값이 일치하는 행들만 조인돼서 조회한다. 대부분 PK와 FK관계를 기반으로 함.

### [표현법]

1. 오라클 전용 구문

        SELECT 컬럼, 컬럼, 컬럼, ...
        FROM TABLE1 A, TABLE2 B
        WHERE A.컬럼명 = B.컬럼명;

2. ANSI 표준 구문
        
        SELECT 컬럼, 컬럼, 컬럼, ...
        FROM TABLE1 A
        [INNER] JOIN TABLE2 B ON(A.컬럼명 = B.컬럼명);

## 2. 비등가 조인
> 두 테이블의 컬럼 값이 정확하게 일치하지 않는 경우, 부등호나 BETWEEN 연산자를 통해 조인.