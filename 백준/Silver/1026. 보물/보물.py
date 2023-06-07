N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A_iter = iter(sorted(A))
B_iter = iter(sorted(B, reverse=True))

sum = 0
for i in range(N):
    sum += next(A_iter) * next(B_iter)
print(sum)