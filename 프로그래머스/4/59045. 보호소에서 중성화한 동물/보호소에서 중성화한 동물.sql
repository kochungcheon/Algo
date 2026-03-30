-- 중성화 수술, 보호소에 들어올 당시 중성화 안되었지만, 나갈때는 중성화된 녀석 찾기
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
-- 나갈때는 중성화된 녀석 중
FROM ANIMAL_INS I
    JOIN ANIMAL_OUTS O
        ON I.ANIMAL_ID = O.ANIMAL_ID 
WHERE I.SEX_UPON_INTAKE LIKE '%Intact%'
    AND (O.SEX_UPON_OUTCOME LIKE '%Spayed%' 
         OR O.SEX_UPON_OUTCOME LIKE '%Neutered%')
