from collections import Counter

def solution(nums):
    answer = len(nums) // 2 if len(Counter(nums).keys()) >= len(nums) // 2 else len(Counter(nums).keys())
    return answer