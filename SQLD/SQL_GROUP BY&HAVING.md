
# GROUP BY
> 그룹 기준을 제시할 수 있는 구문, 여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용한다.

## 1 .집계 함수(Aggregate Function)
- 그룹별 결과 출력
- 다중행 함수 중 하나로 GROUP BY절이 없으면 그룹핑 대상이 존재하지 않아 에러 발생.
- WHERE절에 사용 불가
- 공집합에서도 연산 수행

ALL, DISTINCT: 전체 출력, 중복 제외 출력  
SUM, AVG, MAX, VARIAN, STDDEV : NULL을 제외하고 연산  
COUNT : 행(row) 수 출력
- COUNT(*) : NULL 포함
- COUNT(표현식) : NULL 제외

## 2. GROUP BY
- 그루핑 기준 설정
- 별칭(Alias) 사용 불가

## 3. HAVING
- GROUP BY절에 의해 집계된 데이터에 출력 조건을 걺(WHERE절은 SELECT절 조건을 걸기 때문에 제외된 데이터가 GROUP BY의 대상이 아님) 일반적으로 GROUP BY 뒤에 위치함

<BR>
<BR>

참고. ### SQL 실행 순서
> FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY