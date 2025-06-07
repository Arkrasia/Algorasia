import sys
input = sys.stdin.readline

node, edge, start = map(int, input().split())

matrix = [[0]*(node+1) for _ in range(node+1)] #값이 0인 0~node 행렬 생성

# 입력 그래프 인접행렬로 구현
for _ in range(edge):
    a, b = map(int, input().split())
    matrix[a][b] = matrix[b][a] = 1

#dfs - 재귀 사용
dfs_visit = [0]*(node+1)
def dfs(start):
    dfs_visit[start] = 1 #방문
    print(start, end=' ')
    for i in range(1, node+1):
        if matrix[start][i] == 1 and dfs_visit[i] == 0:
            dfs(i)

#bfs - 큐 이용
bfs_visit = [0]*(node+1)
def bfs(start):
    queue = [start]
    bfs_visit[start] = 1 #방문
    while queue: 
        start = queue.pop(0)
        print(start, end = ' ')
        for i in range(1, node+1):
            if(matrix[start][i] == 1 and bfs_visit[i] == 0):
                queue.append(i)
                bfs_visit[i] = 1 #방문


dfs(start)
print()
bfs(start)