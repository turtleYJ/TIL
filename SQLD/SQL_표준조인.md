
# 표준조인
1. SQL에서의 연산

<table>
  <tr>
    <th rowspan ="4">집합 연산</th>
    <td style="text-align:center">UNION</td>
    <td style="text-align:center">UNION</td>
    <td style="text-align:left">합집합</td>
  </tr>
  <tr>
    <td>INTERSECTION</td>
    <td>INTERSECT</td>
    <td>교집합</td>
  </tr>
  <tr>
    <td>DIFFERENCE</td>
    <td>MINUS(오라클) <br> EXCEPT (SQL Server)</td>
    <td>차집합</td>
  </tr>
  <tr>
    <td>PRODUCTR</td>
    <td>CROSS JOIN</td>
    <td>곱집합(생길 수 있는 모든 데이터의 조합</td>
  </tr>

  <tr>
    <th rowspan ="4">관계 연산</th>
    <td>SELECT</td>
    <td>WHERE절</td>
    <td>조건에 맞는 행 조회</td>
  </tr>
  <tr>
    <td>PROJECT</td>
    <td>SELECT절</td>
    <td>조건에 맞는 컬럼 조회</td>
  </tr>
  <tr>
    <td>JOIN</td>
    <td>여러 JOIN</td>
    <td></td>
  </tr>
  <tr>
    <td>DIVIDE</td>
    <td>없음</td>
    <td>공통요소를 추출하고 분모 릴레이션의 속성을 삭제한 후 중복된 행 제거</td>
  </tr>

</table>