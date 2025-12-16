n = int(input())
answer = 0
gomgom = {}
for i in range(n):
    str = input()
    if(str == 'ENTER'):
        gomgom.clear()
        continue
    if(gomgom.get(str)): continue
    gomgom[str] = 1
    answer += 1
print(answer)