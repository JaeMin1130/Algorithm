def problem_1010():
    t = int(input())
    for i in range(t):
        n, m = map(int, input().split())
        answer = 1
        for i in range(n):
            answer = answer * (m - i) // (i + 1)
        print(answer)

problem_1010()