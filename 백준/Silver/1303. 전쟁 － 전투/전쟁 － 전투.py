col, row = map(int, input().split(" "))

map = [[i for i in input()] for _ in range(row)]

wp = 0
bp = 0

q = []
isVisited = [[False for _ in range(col)] for _ in range(row)]
directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]

for i in range(row):
    for j in range(col):
        if isVisited[i][j] : continue
        soldier = map[i][j]
        q.append([i, j, soldier])
        isVisited[i][j] = True
        count = 1
        while len(q) != 0: 
            curLoc = q.pop()
            cx = curLoc[0]
            cy = curLoc[1]
            value = curLoc[2]
            for dir in directions:
                nx = cx + dir[0]
                ny = cy + dir[1]

                if nx < 0 or nx >= row or ny < 0 or ny >= col: continue
                if isVisited[nx][ny]: continue
                if map[nx][ny] != value: continue

                q.append([nx, ny, map[nx][ny]])
                isVisited[nx][ny] = True
                count += 1

        if soldier == 'W':
            wp += count ** 2
        else:
            bp += count ** 2

print(wp, bp)  