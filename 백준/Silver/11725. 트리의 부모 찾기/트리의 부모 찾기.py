from collections import defaultdict
from collections import deque
import sys
input = sys.stdin.readline

relation = defaultdict(list)

n = int(input().rstrip())
for i in range(n - 1):
    line =  input().split()
    relation[line[0]].append(line[1])
    relation[line[1]].append(line[0])

q = deque()
head = [0] * (n + 1)
head[1] = 1

for i in relation['1']:
    q.append(i)
    head[int(i)] = 1

while q:
    num = q.popleft()
    for i in relation[num]:
        if head[int(i)] == 0:
            q.append(i)
            head[int(i)] = int(num)

for i in range(2, len(head)):
    print(head[i])