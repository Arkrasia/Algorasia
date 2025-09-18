# 백준 16234 인구 이동
import sys
from collections import deque 
input = sys.stdin.readline

n, l, r = map(int, input().split())
people = [list(map(int, input().split())) for _ in range(n)]

q = deque()
dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs(x,y):
    q.append((x,y))
    union = []
    union.append((x,y))
    while q:
        a,b = q.popleft()
        for i in range(4):
            na = a + dx[i]
            nb = b + dy[i]
            if na>=n or nb>=n or nb<0 or na<0 or visited[na][nb]==1:
                continue
            if r >= abs(people[a][b] - people[na][nb]) >= l:
                visited[na][nb] = 1
                q.append((na,nb))
                union.append((na,nb))
    if len(union) <= 1:
        return 0
    result = sum(people[a][b] for a,b in union)//len(union)
    for a, b in union:
        people[a][b] = result
    return 1

ans = 0
while 1:
    stop = 0
    visited = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0:
                visited[i][j] = 1
                stop += bfs(i,j)
    if stop == 0:
        break
    ans += 1
print(ans)