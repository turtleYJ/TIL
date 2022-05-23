# ROWNUM
## ROWNUM
- Oracle의 ROWNUM은 칼럼과 비슷한 성격의 Pseudo Column 으로써 SQL처리 결과 집합의 각 행에 대해 임시로 부여되는 일련번호이다.
- 테이블이나 집합에서 원하는 만큼의 행만 가져오고 싶을 때, WHERE절에서 행의 개수를 제한하는 목적으로 사용한다.

한 건의 행을 가져오고 싶을 때
- SELECT PLAYER_NAME FROM PLAYER WHERE ROWNUM = 1;
- SELECT PLAYER_NAME FROM PLAYER WHERE ROWNUM <= 1;
- SELECT PLAYER_NAME FROM PLAYER WHERE ROWNUM < 2;

두 건 이상(N)의 행을 가져오고 싶을 때
- SELECT PLAYER_NAME FROM PLAYER WHERE ROWNUM <= N;
- SELECT PLAYER_NAME FROM PLAYER WHERE ROWNUM < N + 1;

