n = int(input())
a = map(int,input().split())

cnt = 0
prv = 0
for nxt in a:
    if prv > nxt: pass
    else: cnt += 1
    prv = nxt
print(cnt)