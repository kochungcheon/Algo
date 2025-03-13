select substring(PRODUCT_CODE, 1, 2) as 'CATEGORY', COUNT('CATEGORY') as 'PRODUCTS'
from PRODUCT
group by substring(PRODUCT_CODE, 1, 2)