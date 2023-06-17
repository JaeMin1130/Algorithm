import sys
input = sys.stdin.readline

n1, n2 = map(int, input().split())
dic = {}

for i in range(1, n1 + 1):
    name = input().rstrip()
    dic[i] = name
    dic[name] = i

for i in range(n2):
    quiz = input().rstrip()
    if quiz.isdigit():
        print(dic.get(int(quiz)))
    else:   
        print(dic.get(quiz))