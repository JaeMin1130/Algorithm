dir = {'N':[-1, 0], 'E':[0, 1], 'S':[1, 0], 'W':[0, -1]}
stack = []
def createField():
    info = input().split()
    field = [[0 for j in range(int(info[1]))] for i in range(int(info[0]))]
    for i in range(int(info[2])):
        cabbage = input().split()
        field[int(cabbage[0])][int(cabbage[1])] = 1
    return field

def check(x, y):
    try:
        for i in dir.values():
            idx_X = x + i[0]
            idx_Y = y + i[1]
            if(idx_X < 0 or idx_X >= len(field) or idx_Y < 0 or idx_Y >= len(field[0])):
                continue
            if(field[idx_X][idx_Y] == 1):
                stack.append([idx_X, idx_Y])
                return [idx_X, idx_Y]
        return False
    except: 
        return False
    finally:
        field[x][y] = 0
T = int(input())
for i in range(0, T):      
    count = 0
    field = createField()
    for j in range(len(field)):
        for k in range(len(field[j])):
            if(field[j][k] == 1):
                stack.append([j, k])
                count += 1
                x = j 
                y = k
                while(True):
                    if check(x, y) == False and len(stack) != 0:
                        back = stack[-1]
                        x = back[0]
                        y = back[1]
                    elif check(x, y):
                        result = check(x, y)
                        x = result[0]
                        y = result[1]
                    if(len(stack) > 0): stack.pop()
                    else: break
    print(count)