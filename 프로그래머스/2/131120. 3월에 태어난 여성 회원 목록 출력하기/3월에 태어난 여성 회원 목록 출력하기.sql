SELECT member_id, member_name, gender, substr(date_of_birth, 1, 10) as "date_of_birth"
    from member_profile
    where 1 = 1
        and substr(date_of_birth, 6, 2) = '03'
        and gender = 'W'
        and tlno is not null
    order by member_id asc;