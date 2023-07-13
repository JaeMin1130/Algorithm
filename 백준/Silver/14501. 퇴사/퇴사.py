from collections import deque
import sys

input = sys.stdin.readline
N = int(input().rstrip())
sch = [list(map(int, input().split())) for _ in range(N)]


time = list(map(lambda t: t[0], sch))
pay = list(map(lambda p: p[1], sch))
memo = [0] * N

def DP(day, memo):
    if memo[day] != 0:
        return memo[day]
    else:
        nextDay = day + time[day]  

        if nextDay < N:
            dayList = [nextDay + i for i in range(0, N - nextDay)]
            incomeList = [DP(d, memo) for d in dayList] 
            memo[day] = pay[day] + max(incomeList)
        elif nextDay == N:
            memo[day] += pay[day]

        return memo[day]
    
for day in range(N):
    DP(day, memo)

print(max(memo))