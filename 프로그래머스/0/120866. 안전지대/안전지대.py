from functools import reduce

def solution(board):
    dirs = [[-1, -1], [-1, 0], [-1, 1], 
           [0, -1], [0, 1],
           [1, -1], [1, 0], [1, 1]]
    n = len(board)
    
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                for dir in dirs:
                    nx = i + dir[0]
                    ny = j + dir[1]
                    if nx >= 0 and nx < n and ny >= 0 and ny < n:
                        if board[nx][ny] != 1:
                            board[nx][ny] = 2
                            
    answer = 0                    
    for i in range(n):
        for j in range(n):
            if board[i][j] == 0:
                answer += 1
                
    return answer