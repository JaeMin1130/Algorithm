select substr(product_code, 1, 2) as category, count(*) as count
    from product
    group by substr(product_code, 1, 2)
    order by category asc;
    