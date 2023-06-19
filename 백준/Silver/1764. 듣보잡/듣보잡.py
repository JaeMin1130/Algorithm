import sys
input = sys.stdin.readline

N, M = map(int, input().split())
Narr = set([input().rstrip() for _ in range(N)])

name = [input().rstrip() for _ in range(M)]

result = list(filter(lambda i: i in Narr, name))
result = sorted(result)

print(len(result))
print(*result, sep="\n")