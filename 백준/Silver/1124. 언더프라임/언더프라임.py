import math

A, B = map(int, input().split(" "))

isPrime = [True] * 100001
isPrime[0] = False
isPrime[1] = False
for i in range(2, int(math.sqrt(50000)) + 1):
    if isPrime[i]:
        for j in range(i * i, len(isPrime), i):
            isPrime[j] = False

answer = 0
for num in range(A, B + 1):
    count = 0
    for i in range(2, int(math.sqrt(num) + 1)):
        while num % i == 0:
            count += 1
            num //= i
    if num != 1:
        count += 1

    if isPrime[count]:
        answer += 1

print(answer)