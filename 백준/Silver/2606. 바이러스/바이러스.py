def dfs(dic, cpu, worm):
    next = list(filter(lambda i: i not in worm, dic[cpu]))
    
    if(cpu not in worm):
        worm.append(cpu)
    if len(next) != 0:
        for i in next:
            dfs(dic, i, worm)
    else:
        return

cpu = int(input())
line = int(input())
dic = {}

for i in range(line):
    val = input().split()
    if val[0] not in dic.keys():
        dic[val[0]] = [val[1]]
    else:
        dic[val[0]].append(val[1])

    if val[1] not in dic.keys():
        dic[val[1]] = [val[0]]
    else:
        dic[val[1]].append(val[0])
        
worm = []
dfs(dic, '1', worm)
print(len(worm) - 1)