# 백준 13460 구슬 탈출 2
from collections import deque

n, m = map(int, input().split())
board = [list(map(str, input())) for _ in range(n)]
visited = []

# 방향
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def getIndex():
    rx, ry, bx, by = 0, 0, 0, 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == "R":
                rx, ry = i, j
            if board[i][j] == "B":
                bx, by = i, j
    return rx, ry, bx, by

def move(x, y, dx, dy):
    cnt = 0
    # 이동하는 위치가 벽이아니고, 구멍에 들어가지 않을 동안 반복
    while board[x + dx][y + dy] != "#" and board[x][y] != "O":
        x += dx
        y += dy
        cnt +=1
    return x, y, cnt

def bfs():
    rx, ry, bx, by = getIndex()

    q = deque()
    q.append((rx, ry, bx, by, 1))
    visited.append((rx, ry, bx, by))

    while q:
        rx, ry, bx, by, result = q.popleft()
 
        if result > 10:
            break
 
        for i in range(4):
            nrx, nry, rcnt = move(rx, ry, dx[i], dy[i])
            nbx, nby, bcnt = move(bx, by, dx[i], dy[i])
 
            # 파란 구슬이 구멍에 들어갈 경우
            if board[nbx][nby] == "O":
                continue
 
            # 빨간 구슬이 들어갈 경우 성공
            if board[nrx][nry] == "O":
                print(result)
                return
 
            # 둘이 겹쳐있을 경우
            if nrx == nbx and nry == nby:
                if rcnt > bcnt:
                    nrx -= dx[i]
                    nry -= dy[i]
                else:
                    nbx -= dx[i]
                    nby -= dy[i]
 
            # 탐색하지 않은 방향 탐색
            if (nrx, nry, nbx, nby) not in visited:
                visited.append((nrx, nry, nbx, nby))
                q.append((nrx, nry, nbx, nby, result + 1))
    print(-1)
 
bfs()