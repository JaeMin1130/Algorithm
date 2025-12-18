import sys

def problem_20920():
    n, m = map(int, sys.stdin.readline().rstrip().split())
    words = dict()
    for i in range(n):
        word = sys.stdin.readline().rstrip()
        if len(word) < m: continue
        cnt = words.get(word)
        words[word] = 1 if cnt == None else cnt + 1
    
    for word, _ in sorted(words.items(), key=lambda item: (-item[1], -len(item[0]), item[0])):
        print(word)

problem_20920()