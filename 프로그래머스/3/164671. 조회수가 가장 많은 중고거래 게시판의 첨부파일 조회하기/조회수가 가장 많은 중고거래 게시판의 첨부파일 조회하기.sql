-- 코드를 입력하세요 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회하는 SQL문 FILE ID를 기준으로 내림차순 정렬
SELECT
    CONCAT(
        "/home/grep/src/",
        F.BOARD_ID,
        "/",
        F.FILE_ID,
        F.FILE_NAME,
        F.FILE_EXT
    ) AS 'FILE_PATH'
FROM USED_GOODS_BOARD B
    JOIN USED_GOODS_FILE F
        ON B.BOARD_ID = F.BOARD_ID
WHERE B.VIEWS = 
    (
        SELECT MAX(USED_GOODS_BOARD.VIEWS)
        FROM USED_GOODS_BOARD
    )
ORDER BY F.FILE_ID DESC
