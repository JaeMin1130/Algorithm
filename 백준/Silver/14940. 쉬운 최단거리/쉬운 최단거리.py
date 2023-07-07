from collections import deque

row, col = map(int, input().split())

board = []
visitable = [[True] * col for _ in range(row)]
count = 0
step = [deque() for _ in range(100000)]
dir = [[-1, 0], [0, 1], [1, 0], [0, -1]]

for i in range(row):
    line = list(map(int, input().split()))
    for j in range(len(line)):
        if line[j] == 2:
            step[0].append([i, j])
            visitable[i][j] = False
        elif line[j] == 0:
            visitable[i][j] = False
    board.append(line)

while step[count]:
    idx = step[count].popleft()
    cur_x, cur_y = idx[0], idx[1]
    board[cur_x][cur_y] = count

    for d in dir:
        next_x, next_y = cur_x + d[0], cur_y + d[1]
        if next_x >= 0 and next_x < row and next_y >= 0 and next_y < col:
            if visitable[next_x][next_y]:
                step[count+1].append([next_x, next_y])
                visitable[next_x][next_y] = False

    if len(step[count]) == 0:
        count += 1

for i in range(row):
    for j in range(col):
        if visitable[i][j]:
            print(-1, end=" ")
        else:
            print(board[i][j], end=" ")
    print()