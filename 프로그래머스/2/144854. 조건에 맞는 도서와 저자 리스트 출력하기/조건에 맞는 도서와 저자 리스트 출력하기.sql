select book_id, author_name, to_char(published_date, 'RRRR-MM-DD') PUBLISHED_DATE
    from book b
    join author a using (author_id)
    where category = '경제'
    order by published_date asc;

    