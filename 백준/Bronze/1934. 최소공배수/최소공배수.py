from math import prod
import sys
input = sys.stdin.readline

T = int(input().rstrip())
for i in range(T):
    num = list(map(int, input().split()))
    big, small = max(num), min(num)
    divNum = small
    arr = []

    while divNum >= 2:
        if big % divNum == 0 and small % divNum == 0:
            arr.append(divNum)
            big //= divNum
            small //= divNum
            divNum = small
        else:
            divNum -= 1

    print(big * small * prod(arr))