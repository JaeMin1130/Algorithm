select category, sum(sales) as total_sales
    from book b, book_sales s
    where 1=1
        and b.book_id = s.book_id
        and to_char(sales_date, 'YYYY-MM') = '2022-01'
    group by category
    order by category
    
