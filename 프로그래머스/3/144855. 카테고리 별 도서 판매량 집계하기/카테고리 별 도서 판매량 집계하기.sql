select BOOK.CATEGORY, sum(BOOK_SALES.SALES) as TOTAL_SALES
from BOOK JOIN BOOK_SALES on BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
where SALES_DATE like '2022-01%'
group by BOOK.CATEGORY
order by BOOK.CATEGORY