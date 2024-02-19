def solution(n):
    answer = 0
    
    memo = [0 for i in range(0, 11)]
    memo[1] = 1
    for i in range(2, 11):
        memo[i] = i * memo[i - 1]
        
    for i in range(1, 11):
        if memo[i] == n:
            answer = i
            break
        elif memo[i] > n:
            answer = i - 1
            break
            
    return answer
