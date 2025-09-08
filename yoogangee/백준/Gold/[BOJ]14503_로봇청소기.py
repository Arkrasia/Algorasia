from collections import deque

n, m = map(int, input().split())
r, c, d = map(int, input().split())
rooms = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
cnt = 0

def bfs(x, y, d):
    global cnt
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    cnt += 1
    while q:
        x, y = q.popleft()
        turn = 0
        for i in range(4):
            d = (d + 3) % 4
            nx, ny = x + dx[d], y + dy[d]
            
            if 0 <= nx < n and 0 <= ny < m and not rooms[nx][ny]:
                if not visited[nx][ny]:
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    turn = 1
                    cnt += 1
                    break
        if turn == 0:
            bx, by = x - dx[d], y - dy[d]
            if rooms[bx][by] == 1:
                print(cnt)
                break
            else:
                q.append((bx, by))

bfs(r, c, d)