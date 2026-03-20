-- 코드를 작성해주세요 회사의 부서 정보 , 회사의 사원 정보, 사원의 평가 정보
-- 2022년도 한해 평가 점수가 가장 높은 사원 정보를 조회 / 2022년도 평가 점수가 가장 높은 사원들의 점수, 사번, 성명, 직책, 이메일을 조회하는 SQL문을 작성
SELECT 
    SUM(G.SCORE) AS SCORE,
    E.EMP_NO,
    E.EMP_NAME,
    E.POSITION,
    E.EMAIL
FROM HR_EMPLOYEES E
JOIN HR_GRADE G ON E.EMP_NO = G.EMP_NO
WHERE G.YEAR = 2022
GROUP BY E.EMP_NO
ORDER BY SCORE DESC
LIMIT 1;