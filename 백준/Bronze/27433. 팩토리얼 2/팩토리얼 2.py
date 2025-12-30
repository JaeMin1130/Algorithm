def problem_27433():
    n = int(input())
    def factorial(num, result):
        if num == 0: return result
        return factorial(num - 1, result * num)
    answer = factorial(n, 1)
    print(answer)

problem_27433()