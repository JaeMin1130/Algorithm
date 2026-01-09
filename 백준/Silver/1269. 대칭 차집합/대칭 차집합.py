import sys
from collections import Counter
def problem_1269():
    n, m = map(int, sys.stdin.readline().split())
    A = list(map(int, sys.stdin.readline().split()))
    B = list(map(int, sys.stdin.readline().split()))
    C = Counter(A + B)
    
    answer = 0
    for i in C.keys():
        if C.get(i) >= 2: continue
        answer += 1
    print(answer)

problem_1269()