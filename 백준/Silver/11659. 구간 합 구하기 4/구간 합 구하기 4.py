import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

prefix = [0]
for i in range(N):
    prefix += [arr[i] + prefix[i]]
    
for i in range(M):
    start, end = list(map(int, input().split()))
    print(prefix[end] - prefix[start - 1])