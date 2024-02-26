import sys

input = sys.stdin.readline

n1, n2 = [int(i) for i in input().split(" ")]


def uclid(n1, n2):
    if n2 == 0:
        return n1
    else:
        return uclid(n2, n1 % n2)


gcd = uclid(n1, n2)

print(n1 * n2 // gcd)