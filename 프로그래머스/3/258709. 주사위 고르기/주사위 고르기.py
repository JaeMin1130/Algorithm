import itertools
from collections import Counter

def calculate_outcome_probability(dice_A, dice_B):
    sum_list_A = Counter()
    sum_list_B = Counter()
    for roll_A in itertools.product(*dice_A):
        sum_list_A[sum(roll_A)] += 1
    for roll_B in itertools.product(*dice_B):
        sum_list_B[sum(roll_B)] += 1
    
    count = 0;
    for sum_A in sorted(sum_list_A.keys()):
        for sum_B in sorted(sum_list_B.keys()):
            
            val = sum_list_A[sum_A] * sum_list_B[sum_B]
            
            if sum_A > sum_B:
                count += val
            
    return count
            
def solution(dice):
    n = len(dice)
    half_n = n // 2
    best_combination = None
    max_count = 0
    
    for combination in itertools.combinations(range(n), half_n):
        A_indices = list(combination)
        B_indices = [i for i in range(n) if i not in A_indices]
        
        dice_A = [dice[i] for i in A_indices]
        dice_B = [dice[i] for i in B_indices]
        
        count = calculate_outcome_probability(dice_A, dice_B)
        
        if count > max_count:
            max_count = count
            best_combination = A_indices
            
    return sorted([i + 1 for i in best_combination])