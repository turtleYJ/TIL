-----------------------------------------------------------------------
/*
    4. 비등가 조인(NON EQUAL JOIN)
        조인 조건에 등호(=)를 사용하지 않는 조인문을 비등가 조인이라고 한다.
        지정한 컬럼 값이 일치하는 경우가 아닌, 값의 범위에 포함되는 행들을 연결하는 방식이다.
        (= 이외의 비교 연산자, >, <, >=, <=, BETWEEN AND, IN, NOT IN 등을 사용한다.)
*/
-- EMPLOYEE 테이블과 SAL_GRADE테이블을 비등가 조인하여 사원명, 급여, 급여 등급 조회

SELECT * FROM SAL_GRADE;

SELECT E.EMP_NAME, E.SALARY, S.SAL_LEVEL
FROM EMPLOYEE E
JOIN SAL_GRADE S ON(E.SALARY BETWEEN MIN_SAL AND MAX_SAL);
