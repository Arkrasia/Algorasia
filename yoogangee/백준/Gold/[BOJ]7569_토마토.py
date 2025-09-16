import sys
from collections import deque
n, m, h = map(int, sys.stdin.readline().split())
box = [[list(map(int, sys.stdin.readline().split())) for _ in range(m)] for _ in range(h)]

dx = [0,0,-1,1,0,0] # 상하좌우앞뒤
dy = [1,-1,0,0,0,0]
dz = [0,0,0,0,-1,1]

q = deque()
for i in range(h):
    for j in range(m):
        for k in range(n):
            if box[i][j][k]==1:
                q.append((i,j,k,0))

age = []
def bfs():
    while q:
        x,y,z,count = q.popleft()
        age.append(count+1)
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if nx<0 or ny<0 or nz<0 or nx>=h or ny>=m or nz>=n: 
                continue
            if box[nx][ny][nz] == 0:
                box[nx][ny][nz] = 1
                q.append((nx,ny,nz,count+1))

bfs()
flag = True
for i in range(h):
    for j in range(m):
        for k in range(n):
            if box[i][j][k] == 0:
                flag = False

if flag == False:
    print(-1)
else:
    print(max(age)-1)