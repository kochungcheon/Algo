-- 코드를 입력하세요
select MCDP_CD as '진료과 코드', COUNT(*) as '5월예약 건수'
from APPOINTMENT
where APNT_YMD like '2022-05%'
group by MCDP_CD
order by COUNT(*) , MCDP_CD