import sys
def problem_25192():
    n = int(input())
    answer = 0
    gomgom = set()
    for i in range(n):
        str = sys.stdin.readline()
        if(str == 'ENTER\n'):
            answer += len(gomgom)
            gomgom.clear()
        else:
            gomgom.add(str)
    print(answer + len(gomgom))

problem_25192()