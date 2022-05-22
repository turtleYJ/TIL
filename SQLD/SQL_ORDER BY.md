
# ORDER BY

## 1. ORDER BY
> 특정 칼럼을 기준으로 정렬, 기본 정렬기준은 오름차순
- 칼럼명, 별칭, 칼럼의 SELECT절에서의 순서로 칼럼 지정 가능
- SELECT절에 없는 칼럼도 지정 가능
- Oracle은 NULL을 최대값으로 취급(SQL Server은 최소값으로 취급)

참고. ### SQL 실행 순서
> FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY