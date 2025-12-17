import sys
def problem_26069():
    n = int(input())
    rainbow = set()
    rainbow.add('ChongChong')
    for i in range(n):
        people = sys.stdin.readline().split()
        if people[0] in rainbow:
            if people[1] not in rainbow: rainbow.add(people[1])
        elif people[1] in rainbow:
            if people[0] not in rainbow: rainbow.add(people[0])
    print(len(rainbow))

problem_26069()