/*
    <JOIN>
        두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용되는 구문이다.
        무작정 데이터를 가져오는 게 아니라 각 테이블 간에 공통된 컬럼으로 데이터를 합쳐서 하나의 결과(RESULT SET)로 조회한다.
        
        오라클 전용 구문 / ANSI 표준 구문
*/

----------------------------- 실습문제1 -------------------------------------------------

SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;


-- 각 사원들의 사번, 사원명, 부서코드, 부서명을 조회
-- 오라클
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_CODE = D.DEPT_ID;

-- ANSI
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID);

SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;
SELECT * FROM NATIONAL;

-- 5. 사번, 사원명, 부서명, 지역명, 국가명 조회
-- 오라클 구문
SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, L.LOCAL_NAME, N.NATIONAL_NAME
FROM EMPLOYEE E, DEPARTMENT D, LOCATION L, NATIONAL N
WHERE E.DEPT_CODE = D.DEPT_ID AND D.LOCATION_ID = L.LOCAL_CODE AND L.NATIONAL_CODE = N.NATIONAL_CODE;
-- ANSI 구문
SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_TITLE, L.LOCAL_NAME, N.NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON(L.NATIONAL_CODE = N.NATIONAL_CODE);

-- 6. 사번, 사원명, 부서명, 지역명, 국가명, 급여 등급 조회 (NON EQUAL JOIN 후에 실습 진행)
-- 오라클 구문

-- ANSI 구문




SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;
SELECT * FROM NATIONAL;

--------------------------- 실습문제2 ---------------------------------------------
-- 1. 직급이 대리이면서 ASIA 지역에서 근무하는 직원들의 사번, 사원명, 직급명, 부서명, 근무지역, 급여를 조회하세요.(EMPLOYEE, DEPARTMENT, JOB, LOCATION, NATIONAL)
-- 오라클 구문
SELECT E.EMP_ID, E.EMP_NAME, J.JOB_NAME, D.DEPT_TITLE, L.LOCAL_NAME, E.SALARY
FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION L, NATIONAL N
WHERE E.JOB_CODE = J.JOB_CODE AND E.DEPT_CODE = D.DEPT_ID AND D.LOCATION_ID = L.LOCAL_CODE AND L.NATIONAL_CODE = N.NATIONAL_CODE
      AND J.JOB_NAME = '대리' AND L.LOCAL_NAME LIKE 'ASIA%';
-- ANSI 구문
SELECT E.EMP_ID, E.EMP_NAME, J.JOB_NAME, D.DEPT_TITLE, L.LOCAL_NAME, E.SALARY
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON(L.NATIONAL_CODE = N.NATIONAL_CODE)
WHERE J.JOB_NAME = '대리' AND L.LOCAL_NAME LIKE 'ASIA%';

-- 2. 70년대생 이면서 여자이고, 성이 전 씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하세요. (EMPLOYEE, DEPARTMENT, JOB)
-- 오라클 구문
SELECT E.EMP_NAME, E.EMP_NO, D.DEPT_TITLE, J.JOB_NAME 
FROM EMPLOYEE E, JOB J, DEPARTMENT D
WHERE E.JOB_CODE = J.JOB_CODE AND E.DEPT_CODE = D.DEPT_ID
      AND SUBSTR(E.EMP_NO, 1, 2) BETWEEN 70 AND 79 AND SUBSTR(E.EMP_NO, 8, 1) = '2' AND SUBSTR(E.EMP_NAME, 1, 1) = '전';
-- ANSI 구문
SELECT E.EMP_NAME, E.EMP_NO, D.DEPT_TITLE, J.JOB_NAME 
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
WHERE SUBSTR(E.EMP_NO, 1, 2) BETWEEN 70 AND 79 AND SUBSTR(E.EMP_NO, 8, 1) = '2' AND SUBSTR(E.EMP_NAME, 1, 1) = '전';

-- 3. 보너스를 받는(BONUS IS NOT NULL) 직원들의 사원명, 보너스, 연봉, 부서명, 근무지역을 조회하세요. 
--    단, 부서 코드가 없는 사원도 출력될 수 있게 Outer JOIN 사용
-- 오라클 구문
SELECT E.EMP_NAME, E.BONUS, E.SALARY, D.DEPT_TITLE, L.LOCAL_NAME
FROM EMPLOYEE E, DEPARTMENT D, LOCATION L
WHERE E.DEPT_CODE = D.DEPT_ID(+) AND D.LOCATION_ID = L.LOCAL_CODE(+)
      AND BONUS IS NOT NULL;

-- ANSI 구문
SELECT E.EMP_NAME, E.BONUS, E.SALARY, D.DEPT_TITLE, L.LOCAL_NAME
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
LEFT JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
WHERE BONUS IS NOT NULL;

-- 4. 한국과 일본에서 근무하는 직원들의 사원명, 부서명, 근무지역, 근무 국가를 조회하세요.
-- 오라클 구문
SELECT E.EMP_NAME, D.DEPT_TITLE, L.LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E, DEPARTMENT D, LOCATION L, NATIONAL N
WHERE E.DEPT_CODE = D.DEPT_ID AND D.LOCATION_ID = L.LOCAL_CODE AND L.NATIONAL_CODE = N.NATIONAL_CODE 
      AND N.NATIONAL_NAME IN ('한국', '일본');

-- ANSI 구문
SELECT E.EMP_NAME, D.DEPT_TITLE, L.LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON(L.NATIONAL_CODE = N.NATIONAL_CODE)
WHERE N.NATIONAL_NAME IN ('한국', '일본');

-- 5. 각 부서별 평균 급여를 조회하여 부서명, 평균 급여(정수 처리)를 조회하세요.
--    단, 부서 배치가 안된 사원들의 평균도 같이 나오게끔 해주세요^^
-- 오라클 구문
SELECT D.DEPT_TITLE, TO_CHAR(ROUND(NVL(AVG(E.SALARY), 0)), 'L9,999,999') AS "평균 급여"
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_CODE = D.DEPT_ID(+)
GROUP BY D.DEPT_TITLE
ORDER BY 1 NULLS FIRST;

-- ANSI 구문
SELECT D.DEPT_TITLE, TO_CHAR(ROUND(NVL(AVG(E.SALARY), 0)), 'L9,999,999') AS "평균 급여"
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
GROUP BY D.DEPT_TITLE
ORDER BY 1 NULLS FIRST;

-- 6. 각 부서별 총 급여의 합이 1000만원 이상인 부서명, 급여의 합을 조회하시오.
-- 오라클 구문
SELECT D.DEPT_TITLE, TO_CHAR(SUM(SALARY), 'L99,999,999') AS "급여의 합"
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_CODE = D.DEPT_ID
GROUP BY D.DEPT_TITLE
HAVING SUM(SALARY) > 10000000
ORDER BY 1;

-- ANSI 구문
SELECT D.DEPT_TITLE, TO_CHAR(SUM(SALARY), 'L99,999,999') AS "급여의 합"
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
GROUP BY D.DEPT_TITLE
HAVING SUM(SALARY) > 10000000
ORDER BY 1;

-- 7. 사번, 사원명, 직급명, 급여 등급, 구분을 조회 (NON EQUAL JOIN 후에 실습 진행)
--    이때 구분에 해당하는 값은 아래와 같이 조회 되도록 하시오.
--    급여 등급이 S1, S2인 경우 '고급'
--    급여 등급이 S3, S4인 경우 '중급'
--    급여 등급이 S5, S6인 경우 '초급'
-- 오라클 구문

-- ANSI 구문
SELECT E.EMP_ID, 
       E.EMP_NAME, 
       J.JOB_NAME, 
       S.SAL_LEVEL,
       CASE
            WHEN S.SAL_LEVEL IN('S1', 'S2') THEN '고급'
            WHEN S.SAL_LEVEL IN('S3', 'S4') THEN '중급'
            WHEN S.SAL_LEVEL IN('S5', 'S6') THEN '초급'
       END AS "구분"
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
JOIN SAL_GRADE S ON(E.SALARY BETWEEN MIN_SAL AND MAX_SAL);

SELECT * FROM SAL_GRADE;
-- 8. 보너스를 받지 않는 직원들 중 직급 코드가 J4 또는 J7인 직원들의 사원명, 직급명, 급여를 조회하시오.
-- 오라클 구문
SELECT EMP_NAME, JOB_NAME, E.SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
      AND E.BONUS IS NULL AND E.JOB_CODE IN('J4', 'J7');

-- ANSI 구문
SELECT EMP_NAME, JOB_NAME, E.SALARY
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE E.BONUS IS NULL AND E.JOB_CODE IN('J4', 'J7');

SELECT * FROM LOCATION;
SELECT * FROM JOB;
SELECT * FROM EMPLOYEE;

-- 9. 부서가 있는 직원들의 사원명, 직급명, 부서명, 근무 지역을 조회하시오.
-- 오라클 구문
SELECT E.EMP_NAME, J.JOB_NAME, D.DEPT_TITLE, L.LOCAL_NAME
FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION L
WHERE E.JOB_CODE = J.JOB_CODE AND E.DEPT_CODE = D.DEPT_ID AND D.LOCATION_ID = L.LOCAL_CODE
      AND E.DEPT_CODE IS NOT NULL;

-- ANSI 구문
SELECT E.EMP_NAME, J.JOB_NAME, D.DEPT_TITLE, L.LOCAL_NAME
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
JOIN LOCATION L ON(D.LOCATION_ID = L.LOCAL_CODE)
WHERE E.DEPT_CODE IS NOT NULL;

-- 10. 해외영업팀에 근무하는 직원들의 사원명, 직급명, 부서 코드, 부서명을 조회하시오
-- 오라클 구문
SELECT E.EMP_NAME, J.JOB_NAME, E.DEPT_CODE, D.DEPT_TITLE
FROM EMPLOYEE E, DEPARTMENT D, JOB J
WHERE E.JOB_CODE = J.JOB_CODE AND E.DEPT_CODE = D.DEPT_ID
      AND D.DEPT_TITLE LIKE '해외영업%';

-- ANSI 구문
SELECT E.EMP_NAME, 
       J.JOB_NAME, 
       E.DEPT_CODE, 
       D.DEPT_TITLE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(E.DEPT_CODE = D.DEPT_ID)
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE D.DEPT_TITLE LIKE '해외영업%';
      
-- 11. 이름에 '형'자가 들어있는 직원들의 사번, 사원명, 직급명을 조회하시오.
-- 오라클 구문
SELECT E.EMP_ID, E.EMP_NAME, J.JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
      AND E.EMP_NAME LIKE '%형%';

-- ANSI 구문
SELECT E.EMP_ID AS "사번", 
       E.EMP_NAME AS "사원명", 
       J.JOB_NAME AS "직급명"
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE E.EMP_NAME LIKE '%형%';




