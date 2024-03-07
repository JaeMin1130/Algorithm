select name, datetime
    from animal_ins
    where 1=1
    and animal_id not in (select animal_id from animal_outs)
    order by datetime
    fetch first 3 rows only;