from collections import deque

def createEdges(a, b, edges):
    if(a not in edges.keys()):
        edges[a] = [b]
    elif(b not in edges.values()):
        edges[a].append(b)

# 재귀
def DFS(edges, node, result_dfs):
    edge = edges
    next = sorted(filter(lambda i: i not in result_dfs, edge[node]))
    if(node not in result_dfs):
        result_dfs.append(node)
    if len(next) != 0:
        for i in next:
            DFS(edge, i, result_dfs)

def BFS(edges, node, result_bfs):
    edge = edges
    q = deque()
    q.append(node)
    result_bfs.append(node)
    while q:
        popped = q.popleft()
        if(len(edges[popped]) != 0):
            for i in sorted(edges[popped]):
                if(i not in result_bfs):
                    q.append(i)
                    result_bfs.append(i)
    
def show(result):
    for i in range(len(result)):
        print (result[i] , end = ' ')
    print()
    
N1, N2, startNode = map(int, input().split())

temp = []
for i in range(N2):
    temp.append(list(map(int, input().split())))

edges = {}
for i in range(1, N1+1):
    edges[i] = []
for i in temp:
    createEdges(i[0], i[1], edges)
    createEdges(i[1], i[0], edges)

result_dfs = []
result_bfs = []
DFS(edges, startNode, result_dfs)
BFS(edges, startNode, result_bfs)

show(result_dfs)
show(result_bfs)