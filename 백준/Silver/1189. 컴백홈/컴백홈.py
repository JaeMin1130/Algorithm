row, col, target = map(int, input().split(" "))

map = [[i for i in input()] for _ in range(row)]
map[0][col - 1] = 'g'

directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
answer = 0

def dfs(curLoc, count, isVisited):
    global answer

    for dir in directions:
        nx = curLoc[0] + dir[0]
        ny = curLoc[1] + dir[1]

        if nx < 0 or nx >= row or ny < 0 or ny >= col : continue
        if map[nx][ny] == 'T' : continue
        if isVisited[nx][ny] : continue

        if map[nx][ny] == 'g' : 
            if count + 1 == target : 
                answer = answer + 1
            continue
        else:
            isVisited[nx][ny] = True
            dfs([nx, ny], count + 1, isVisited)
            isVisited[nx][ny] = False

visited = [[False for _ in range(col)] for _ in range(row)]
visited[row - 1][0] = True

dfs([row - 1, 0], 1, visited)

print(answer)