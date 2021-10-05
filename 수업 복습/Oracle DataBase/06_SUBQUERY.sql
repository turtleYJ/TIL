-- 1) 전 직원의 평균 급여보다 급여를 적게 받는 직원들의 이름, 직급 코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (
    SELECT AVG(SALARY)
    FROM EMPLOYEE
);

-- 그룹함수는 WHERE절에 사용 불가
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < AVG(SALARY);

-- 2) 최저 급여를 받는 직원의 사번, 이름, 직급 코드, 급여, 입사일 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

-- 3) 노옹철 사원의 급여보다 더 많이 받는 사원의 사번, 사원명, 부서명, 직급 코드, 급여 조회
SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, E.DEPT_CODE, E.SALARY
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_CODE = D.DEPT_ID 
  AND SALARY > (SELECT SALARY FROM EMPLOYEE WHERE  EMP_NAME = '노옹철');

-- 4) 부서별 급여의 합이 가장 큰 부서의 부서 코드, 급여의 합 조회(보류, 힌트 : where절에 쓰지 말것, groupin  )
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = MAX(SUM(SALARY));

-- 5) 전지연 사원이 속해있는 부서원들 조회 (단, 전지연 사원은 제외)
--    사번, 사원명, 전화번호, 직급명, 부서명, 입사일
SELECT E.EMP_ID, E.EMP_NAME, E.PHONE, J.JOB_NAME, D.DEPT_TITLE, E.HIRE_DATE
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '전지연') AND EMP_NAME != '전지연';

----------------------------------------------------------------
/*
    <다중행 서브 쿼리>
        서브 쿼리의 조회 결과 값의 행의 개수가 여러 행 일 때
        
        IN / NOT IN (서브쿼리) : 여러 개의 결과값 중에서 한 개라도 일치하는 값이 있다면 혹은 없다면 TRUE를 리턴한다.
        ANY : 여러 개의 값들 중에서 한 개라도 만족하면 TRUE, IN과 다른 점은 비교 연산자를 사용한다는 점이다.
            SALARY = ANY(...) : IN과 같은 결과
            SALARY != ANY(...) : NOT IN과 같은 결과
            SALARY > ANY(...) : 최소값 보다 크면 TRUE 리턴
            SALARY < ANY(...) : 최대값 보다 작으면 TRUE 리턴 
        ALL : 여러 개의 값들 모두와 비교하여 만족해야한 TRUE
            SALARY > ALL(...) : 최대값 보다 크면 TRUE 리턴
            SALARY < ALL(...) : 최소값 보다 작으면 TRUE 리턴
*/
-- 1) 각 부서별 최고 급여를 받는 직원의 이름, 직급 코드, 부서 코드, 급여 조회
-- 부서별 최고 급여 조회
SELECT MAX(SALARY) AS "최고 급여"
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 위 급여를 받는 사원들 조회
SELECT EMP_NAME, JOB_CODE, NVL(DEPT_CODE, '부서없음'), SALARY
FROM EMPLOYEE
WHERE SALARY IN (
    SELECT MAX(SALARY)
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
)
ORDER BY 3;

-- 2) 직원에 대해 사번, 이름, 부서 코드, 구분(사수/사원) 조회
-- 사수에 해당하는 사번을 조회
SELECT DISTINCT MANAGER_ID
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL;

-- 사번이 위와 같은 직원들의 사번, 이름, 부서 코드, 구분(사수) 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, '사수' AS "구분"
FROM EMPLOYEE
WHERE EMP_ID IN (
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
);

-- 일반 사원에 해당하는 정보 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, '사원' AS "구분"
FROM EMPLOYEE
WHERE EMP_ID NOT IN (
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
);

-- 위의 결과들을 하나의 결과로 확인 (UNION 방식)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, '사수' AS "구분"
FROM EMPLOYEE
WHERE EMP_ID IN (
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
)

UNION

SELECT EMP_ID, EMP_NAME, DEPT_CODE, '사원' AS "구분"
FROM EMPLOYEE
WHERE EMP_ID NOT IN (
    SELECT DISTINCT MANAGER_ID
    FROM EMPLOYEE
    WHERE MANAGER_ID IS NOT NULL
);

--SELECT 절에 서브 쿼리를 사용하는 방법
SELECT EMP_ID, EMP_NAME, DEPT_CODE, 
       CASE
            WHEN EMP_ID IN (
                SELECT DISTINCT MANAGER_ID 
                FROM EMPLOYEE 
                WHERE MANAGER_ID IS NOT NULL)
            THEN '사수'
            ELSE '사원'
       END AS "구분"
FROM EMPLOYEE;

-- 3) 대리 직급임에도 과장 직급들의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회 (사원 -> 대리 -> 과장 -> 차장 -> 부장)
-- 과장 직급들의 급여 정보
SELECT SALARY
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE JOB_NAME = '과장';

-- 직급이 대리인 직원들 중에서 위 목록들 값 중에 하나라도 큰 경우
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE SALARY > ANY(
    SELECT SALARY
    FROM EMPLOYEE E
    JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
    WHERE JOB_NAME = '과장'
) AND JOB_NAME = '대리';

-- 4) 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원들의 사번, 이름, 직급, 급여 조회 (사원 -> 대리 -> 과장 -> 차장 -> 부장)
-- 차장 직급들의 급여 조회
SELECT SALARY
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE JOB_NAME = '차장';

-- 과장 직급임에도 차장 직급의 최대 급여보다 더 많이 받는 직원
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E
JOIN JOB J USING(JOB_CODE)
WHERE SALARY > ALL(
    SELECT SALARY
    FROM EMPLOYEE E
    JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
    WHERE JOB_NAME = '차장'
) AND JOB_NAME = '과장';

-------------------------------------------------------------------

/*
    <다중열 서브 쿼리>
        조회 결과 값은 한 행이지만 나열된 컬럼 수가 여러 개일 때
*/
-- 1) 하이유 사원과 같은 부서 코드, 같은 직급 코드에 해당하는 사원들 조회
-- 하이유 사원의 부서 코드와 직급 코드 조회
SELECT DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '하이유';

-- 부서 코드가 D5이면서 직급 코드가 J5인 사원들 조회
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D5' AND JOB_CODE = 'J5';

-- 각각 단일행 서브 쿼리로 작성
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = (
    SELECT DEPT_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '하이유'
) AND JOB_CODE = (
    SELECT JOB_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '하이유'
);
-- 다중열 서브 쿼리를 사용해서 하나의 쿼리로 작성
SELECT EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (
    SELECT DEPT_CODE, JOB_CODE
    FROM EMPLOYEE
    WHERE EMP_NAME = '하이유'
);

-- 2) 박나라 사원과 직급 코드가 일치 하면서 같은 사수를 가지고 있는 사원의 사번, 이름, 직급 코드, 사수 사번 조회
-- 박나라 사원의 직급 코드와 사수의 사번을 조회 --> 결과값 1행의 여러열
SELECT JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE EMP_NAME = '박나라';

-- 위 쿼리문을 다중열 서브 쿼리로 사용하는 메인 쿼리문 작성
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (
    SELECT JOB_CODE, MANAGER_ID
    FROM EMPLOYEE
    WHERE EMP_NAME = '박나라'
);

-------------------------------------------------------------------
/*
    <다중행 다중열 서브 쿼리>
        서브 쿼리의 조회 결과값이 여러 행, 여러 열일 경우
*/
-- 1. 각 직급별로 최소 급여를 받는 사원들의 사번, 이름, 직급 코드, 급여 조회
-- 각 직급별 최소 급여 조회
SELECT  JOB_CODE, MIN(SALARY)
FROM EMPLOYEE 
GROUP BY JOB_CODE;

-- 다중행 다중열 서브 쿼리를 사용해서 각 직급별로 최소 급여를 받는 사원의 사번, 이름, 직급 코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (
    SELECT  JOB_CODE, MIN(SALARY)
    FROM EMPLOYEE 
    GROUP BY JOB_CODE
)
ORDER BY JOB_CODE;

-- 2. 각 부서별 최소 급여를 받는 사원들의 사번, 이름, 부서 코드, 급여 조회
-- 각 부서별 최소 급여 조회
SELECT NVL(DEPT_CODE, '부서없음'), MIN(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 다중행 다중열 서브 쿼리를 사용해서 각 부서별로 최소 급여를 받는 사원들의 사번, 이름, 부서 코드, 급여 조회
SELECT EMP_ID, EMP_NAME, NVL(DEPT_CODE, '부서없음'), SALARY
FROM EMPLOYEE
WHERE (NVL(DEPT_CODE, '부서없음'), SALARY) IN (
    SELECT NVL(DEPT_CODE, '부서없음'), MIN(SALARY)
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
)
ORDER BY DEPT_CODE;

/*
    <인라인 뷰>
        FROM 절에 서브 쿼리를 제시하고, 서브 쿼리를 수행한 결과를 테이블 대신에 사용한다.
*/
-- 1) 인라인 뷰를 활용한 TOP-N 문석
-- 전 직원 중 급여가 가장 높은 상위 5명의 순위, 이름, 급여 조회
--  * ROWNUM : 오라클에서 제공하는 컬럼, 조회된 순서대로 1 부터 순번을 부여하는 컬럼
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;

-- 이미 순번이 정해진 다음에 정렬이 되었다.
-- FROM -> SELECT(순번이 정해진다.) -> ORDER BY

-- 해결 방법
-- ORDER BY 한 결과값을 가지고 ROWNUM을 부여하면 된다. (인라인 뷰 사용)
SELECT ROWNUM, EMP_NAME, SALARY
FROM (
    SELECT EMP_NAME, SALARY
    FROM EMPLOYEE
    ORDER BY SALARY DESC
)
WHERE ROWNUM <= 5;

-- 2) 부서별 평균 급여가 높은 3개의 부서의 부서 코드, 평균 급여 조회
SELECT DEPT_CODE, AVG(NVL(SALARY, 0))
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY AVG(NVL(SALARY, 0)) DESC;

SELECT DEPT_CODE, ROUND(평균급여)
FROM (
    SELECT DEPT_CODE, 
           AVG(NVL(SALARY, 0)) AS "평균급여"
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
    ORDER BY AVG(NVL(SALARY, 0)) DESC
)
WHERE ROWNUM <= 3;



























