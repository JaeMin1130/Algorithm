import sys
from collections import Counter
input = sys.stdin.readline

M = input().rstrip()
c = Counter(input().split())

N = input().rstrip()
print(*map(lambda i: c[i], input().split()), sep=" ")