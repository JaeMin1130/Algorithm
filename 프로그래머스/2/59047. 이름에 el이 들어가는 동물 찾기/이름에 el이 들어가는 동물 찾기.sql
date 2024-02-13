select animal_id, name
    from animal_ins
    where 1 = 1
        and animal_type = 'Dog'
        and lower(name) like '%el%'
    order by name asc;