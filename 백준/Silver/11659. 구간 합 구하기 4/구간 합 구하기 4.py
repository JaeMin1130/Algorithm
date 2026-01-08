import sys
def problem_11659():
    n, m = map(int, sys.stdin.readline().split())
    nums = list(map(int, sys.stdin.readline().split()))
    
    sum_nums = [sum(nums)]
    for i in range(n - 1):
        sum_nums.append(sum_nums[i] - nums[i])
    sum_nums.append(0)
    
    for i in range(m):
        start, end = map(int, sys.stdin.readline().split())
        print(sum_nums[start - 1] - sum_nums[end])

problem_11659()