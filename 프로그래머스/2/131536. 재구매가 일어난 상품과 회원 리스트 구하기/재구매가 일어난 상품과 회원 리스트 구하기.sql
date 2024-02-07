-- 코드를 입력하세요
SELECT distinct A.user_id, A.product_id
    from online_sale A, online_sale B
    where 1 = 1 
        and A.user_id = B.user_id
        and A.product_id = B.product_id
        and A.sales_date != B.sales_Date
    order by user_id asc, product_id desc;