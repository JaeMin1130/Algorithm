digits = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
nums, target = input().split()
nums_len = len(nums)
answer = 0

for i in nums:
    digit = digits.index(i)
    place = 1
    for i in range(nums_len - 1): place *= int(target)
    answer += digit * place
    nums_len -= 1

print(answer)