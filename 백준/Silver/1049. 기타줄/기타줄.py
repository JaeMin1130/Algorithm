num_of_line, num_of_brand = map(int, input().split())
set_price = 1000
single_price = 1000
for i in range(num_of_brand):
    input_set, input_single = map(int, input().split())
    if(input_set < set_price):
        set_price = input_set
    if(input_single < single_price):
        single_price = input_single
    
total_price = 0
if set_price >= single_price * 6:
    total_price = single_price * num_of_line
else: 
    if set_price >= single_price * num_of_line:
        total_price = single_price * num_of_line
    else:
        option1 = set_price * (num_of_line // 6) + single_price * (num_of_line % 6)
        option2 = set_price * (num_of_line // 6 + 1)
        total_price = option1 if option1 <= option2 else option2
        
print(total_price)