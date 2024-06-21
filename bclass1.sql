delete from member where user_id='id01';

select * from member;

commit;

select 
    to_char(create_date, 'YYYY-mm-DD')
FROM 
    board;
--날짜 보기 좋게 출력



select 
    length(board_no)
from
    board;







select 
    min(board_no)
from
    board;


-- [그룹함수]
--글 개수 조회

SELECT
			COUNT(BOARD_NO)
		FROM
			BOARD
		WHERE
			STATUS = 'Y';
-- 글 개수 조회지만 나중에 글이 삭제될 경우엔 빼고 조회해야함
--status Y로 넣어줌

--
select 
    board_no,
    board_title,
    board_writer,
    count,
    create_date,
    origin_name, 
    rnum
from
    (select 
        board_no,
        board_title,
        board_writer,
        count,
        create_date,
        origin_name, 
        rownum rnum
    from
        (select 
            board_no,
            board_title,
            board_writer,
            count,
            create_date,
            origin_name
        from
            board
        where
            status = 'Y'
        order
            by
            board_no desc ))
where
    rnum between 11 and 16;
-- 가장 내부에 있는 select문부터 돌려서 해석하기
---


select 
    board_no,
    board_title,
    board_writer,
    count,
    create_date,
    origin_name, 
    rownum rnum
from
    (select 
        board_no,
        board_title,
        board_writer,
        count,
        create_date,
        origin_name
    from
        board
    where
        status = 'Y'
    order
        by
        board_no desc )
where
    rnum between 1 and 16;
    
select 
    board_no,
    board_title,
    board_writer,
    count,
    create_date,
    origin_name
    
from
    board
where
    status = 'Y'
order
    by
    board_no desc; 
    --order by는 제일 마지막에 실행됨


SELECT 
    BOARD_NO,
    BOARD_TITLE,
    BOARD_WRITER,
    COUNT,
    CREATE_DATE,
    ORIGIN_NAME, 
    RNUM
FROM
    (SELECT 
        BOARD_NO,
        BOARD_TITLE,
        BOARD_WRITER,
        COUNT,
        CREATE_DATE,
        ORIGIN_NAME, 
        ROWNUM RNUM
    FROM
        (SELECT 
            BOARD_NO,
            BOARD_TITLE,
            BOARD_WRITER,
            COUNT,
            CREATE_DATE,
            ORIGIN_NAME
        FROM
            BOARD
        WHERE
            STATUS = 'Y'
        ORDER
            BY
            BOARD_NO DESC ))
WHERE
    RNUM BETWEEN 11 AND 16;
    
    
    
-- 조건에 부합하는 게시글의 행의 수 알아내기
-- 작성자, 내용, 제목에 따른 검색
SELECT
    COUNT(BOARD_NO)
FROM
    BOARD
WHERE
    STATUS='Y'
AND
    --사용자가 작성자의 'U'라는 키워드로 검색했을때 
    BOATD_WRITER LIKE '%' || 'U' || '%';


AND
    --사용자가 글 제목의 'U'라는 키워드로 검색했을때 
    BOARD_TITLE LIKE '%' || 'JAVA' || '%';
    
AND
    --사용자가 글 내용의 '다'라는 키워드로 검색했을때 
    BOATD_CONTENT '%' || '다' || '%';
    