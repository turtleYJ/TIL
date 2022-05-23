<!-- Ctrl/Cmd + B	Toggle bold
Ctrl/Cmd + I	Toggle italic
Alt+S (on Windows)	Toggle strikethrough1
Ctrl + Shift + ]	Toggle heading (uplevel)
Ctrl + Shift + [	Toggle heading (downlevel)
Ctrl/Cmd + M	Toggle math environment
Alt + C	Check/Uncheck task list item
Ctrl/Cmd + Shift + V	Toggle preview
Ctrl/Cmd + K V	Toggle preview to side -->

# 연산자
## 연산자 우선순위
1. (), 괄호
2. not 
3. 비교연산자 
4. and 
5. or

## 비교 연산자 
=, > , >= , < , <=

## SQL 연산자
- BETWEEN a AND b : A와 b를 포함한 그 사이의 값
- IN(list) : list에 있는 값들 중에서 어느 하나라도 일치하면 된다.
- LIKE '비교문자열' : 비교문자열과 형태가 일치하면 된다.
- IS NULL : NULL값인 경우.

## 논리 연산자
AND, OR, NOT

## 부정 비교 연산자
-  같지 않다(!=, ^=, <>)
- NOT 컬럼명 = : ~와 같지 않다.
- NOT 컬럼명 > : ~보다 크지 않다.

## 부정 SQL 연산자
- NOT BETWEEN a AND b : a와 b 값 사이에 있지 않다(a, b 미포함)
- NOT IN(list) : list값과 일치히지 않는다.
- IS NOT NULL : NULL 값을 갖지 않는다.


<br>
<br>
<br>

## 문제풀이 중 혼동되었던 부분

- BETWEEN 'A' AND 'B' : A와 b를 포함한 그 사이의 값
- WHERE 절에서 NULL 사용 : IS NOT NULL OR IS NULL이란 키워드 사용