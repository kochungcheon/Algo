-- 코드를 입력하세요
select HOUR(DATETIME) as HOUR, COUNT(*) as 'COUNT'
from ANIMAL_OUTS
where HOUR(DATETIME) >= 9 and HOUR(DATETIME) <= 19
group by HOUR
order by HOUR