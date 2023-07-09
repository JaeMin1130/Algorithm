import sys
input = sys.stdin.readline

def getPrimeArr(num):
    primes = [True] * (num + 1)

    for i in range(3, int(num ** 0.5) + 1, 2):
        if primes[i]:
            for j in range(i * i, num + 1, 2 * i):
                primes[j] = False

    return primes

def findFactor(num, primes):

    for i in range(3, num, 2):
        if primes[i] and primes[num - i]:
            return "{0} = {1} + {2}".format(num, i, num - i)

    return "Goldbach's conjecture is wrong."

primes = getPrimeArr(1000001)
while True:
    num = int(input().rstrip())
    
    if num == 0:
        break
    else:
        print(findFactor(num, primes))