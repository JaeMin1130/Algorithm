n = int(input())
answer = 0
gomgom = set()
for i in range(n):
    str = input()
    if(str == 'ENTER'):
        answer += len(gomgom)
        gomgom.clear()
    else:
        gomgom.add(str)
print(answer + len(gomgom))