def fibonacci(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        if memo[n] != 0:
            return memo[n]
        else:
            memo[n]= fibonacci(n-1) + fibonacci(n-2)
            return memo[n]
        
memo = [0] * 100
T = int(input())
for i in range(0, T):
    n = int(input())
    if n == 0:
        print(1, 0)
    else:
        print(fibonacci(n - 1), fibonacci(n))