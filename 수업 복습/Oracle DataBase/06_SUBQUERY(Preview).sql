-- SUBQUERY 예습
/*
    하나의 SQL 문장 내에 포함된 또 다른 SQL문이 있는 쿼리문
    전체 SQL 문장을 메인 쿼리라고 하며 메인 쿼리에 종속된 내부 쿼리를 서브 쿼리라고 한다.
    서브 쿼리는 반드시 괄호() 안에 넣어 표현해야 한다.
*/

-- 교재 예시
-- 이름이 'KING'인 사원의 부서번호를 조회하는 서브 쿼리와 그 결과로 부서명을 조회하는 메인 쿼리
SELECT E.EMP_NAME, D.DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
WHERE E.DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '전지연');

SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '전지연';

/*
    <단일 행 서브 쿼리>
        서브 쿼리의 결과가 1개의 행만 나오는 것
        서브 쿼리의 결과가 1건만 나오고 이 결과를 메인 쿼리로 전달하여 전체적인 쿼리를 수행한다
        메인 쿼리의 WHERE절에서 단일 행 연산자(=, <>, >, >=, <, <=)를 이용한다
*/

-- 평균 급여보다 많은 급여를 받는 사원 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE);

SELECT AVG(SALARY) FROM EMPLOYEE; -- 단일 행

/*
    < 다중 행 서브 쿼리>
        서브 쿼리의 결과가 두 건 이상 출력되는 것
        단일 행 연산자는 사용할 수 없으며, 다중 행 연산자(IN, NOT IN, ANY, ALL, EXISTS)만 사용 가능
*/
-- IN 연산자
-- 부서별 급여를 제일 많이 받는 사원 조회
SELECT DEPT_TITLE, EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
WHERE SALARY IN (SELECT MAX(SALARY)
                 FROM EMPLOYEE
                 GROUP BY DEPT_CODE);
                 
-- ANY연산자 : 메인 쿼리의 비교 조건이 서브 쿼리의 여러 검색 결과 중 하나 이상 만족되면 반환한다.
-- 영업사원들의 급여를 조회하여 ANY 연산자로 메인 쿼리와 비교하여 출력되도록 해 보자.
-- 영업사원들의 급여 중 최소값보다 많은 급여를 받는 사원들이 출력된다.
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY > ANY(SELECT SALARY
                   FROM EMPLOYEE E
                   JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
                   WHERE D.DEPT_TITLE LIKE '%영업%');

-- 영업사원들의 급여와 같은 급여를 받는 사원을 조회해 보자.
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY = ANY(SELECT SALARY
                   FROM EMPLOYEE E
                   JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
                   WHERE D.DEPT_TITLE LIKE '%영업%');


