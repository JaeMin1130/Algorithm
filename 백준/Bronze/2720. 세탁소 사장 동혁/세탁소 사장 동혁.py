case_cnt = int(input())
coins = [25, 10, 5, 1]
answer = []
for i in range(case_cnt):
    change = int(input())
    row = []
    for coin in coins:
        cnt = change // coin
        row.append(cnt)
        change -= coin * cnt
    answer.append(row)

for row in answer:
    for num in row: 
        print(num, end=' ')
    print()