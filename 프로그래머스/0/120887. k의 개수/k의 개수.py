def solution(i, j, k):
    answer = 0
    
    for num in range(i, j + 1):
        for digit in str(num):
            if str(k) == digit:
                answer += 1
        
    return answer