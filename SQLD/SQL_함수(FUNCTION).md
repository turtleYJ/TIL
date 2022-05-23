# 함수


## 1. 단일행 함수
> SELECT, WHERE, ORDER BY절에 사용 가능

- NULL 관련 함수
  - NVL(칼럼, A) : 컬럼값이 NULL이 아니면 그대로 반환, NULL이면 A 반환
  - NVL2(컬럼, A, B) :컬럼값이 NULL이 아니면 A, NULL이면 B 반환
  - NULLIF(A, B) : A, B 값이 동일하면 NULL, 아니면 A 반환.
  - COALESCE(A, B, C...) : 임의이 인수들(A, B, C) 중 NULL이 아닌 최초의 인수를 반환. 모든 인수가 NULL이면 NULL반환.