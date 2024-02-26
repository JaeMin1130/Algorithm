select to_number(to_char(datetime, 'hh24')) as hour, count(*) as count
    from animal_outs
    group by to_number(to_char(datetime, 'hh24'))
        having  to_number(to_char(datetime, 'hh24')) between '09' and '19'
    order by hour asc