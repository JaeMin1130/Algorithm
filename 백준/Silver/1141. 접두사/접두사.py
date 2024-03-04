n = int(input())
list = sorted([input() for _ in range(n)], key=len)

count = n
for i in range(n - 1):
    for j in range(i + 1, n):
        if list[j].startswith(list[i]):
            count -= 1
            break

print(count)