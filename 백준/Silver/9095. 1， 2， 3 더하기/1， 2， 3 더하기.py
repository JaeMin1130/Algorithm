import sys
def cal(n):
    if n <= 2:
        memo[n] = n
        return memo[n]
    elif n == 3:
        memo[3] = 4
        return memo[3] 
    else:
        memo[n] = cal(n - 1) + cal(n - 2) + cal(n - 3)
        return memo[n]

input = sys.stdin.readline
T = int(input().rstrip())
memo = [0] * 11
for i in range(T):
    print(cal(int(input().rstrip())))
