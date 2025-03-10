select ANIMAL_ID, NAME
from ANIMAL_INS
where ANIMAL_TYPE like 'dog' and (NAME like '%el%' or NAME like '%EL%')
order by NAME