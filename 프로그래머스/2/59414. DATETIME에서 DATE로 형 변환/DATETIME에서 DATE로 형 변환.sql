select animal_id, name, TO_CHAR(datetime, 'RRRR-MM-DD')
    from animal_ins
    order by animal_id;