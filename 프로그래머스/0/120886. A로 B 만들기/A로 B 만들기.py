from collections import Counter

def solution(before, after):
    answer = 0
    
    counter_before = Counter(before)
    counter_after = Counter(after)
    
    if counter_before == counter_after:
        answer = 1

    return answer
