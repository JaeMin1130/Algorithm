select ingredient_type, sum(total_order) as total_order
    from first_half h, icecream_info i
    where h.flavor = i.flavor
    group by ingredient_type    
    order by total_order asc;