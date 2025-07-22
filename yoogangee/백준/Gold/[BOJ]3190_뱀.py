# 백준 3190 뱀
from collections import deque

n = int(input()) # 보드 크기
k = int(input()) # 사과 개수

board = [[0] * n for _ in range(n)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

# 사과 좌표 표시
for i in range(k):
    a, b = map(int, input().split())
    board[a - 1][b - 1] = 2

l = int(input())
direction_dict = dict()
q = deque()
q.append((0, 0))

# 뱀 방향 변환 딕셔너리
for i in range(l):
    x, c = input().split()
    direction_dict[int(x)] = c

x, y = 0, 0
board[x][y] = 1
cnt = 0
direction = 0

def turn(c):
    global direction
    if c == 'L':
        direction = (direction - 1) % 4
    else:
        direction = (direction + 1) % 4


while True:
    cnt += 1
    x += dx[direction]
    y += dy[direction]

    if x < 0 or x >= n or y < 0 or y >= n: break

    if board[x][y] == 2:
        board[x][y] = 1
        q.append((x, y))
        if cnt in direction_dict:
            turn(direction_dict[cnt])

    elif board[x][y] == 0:
        board[x][y] = 1
        q.append((x, y))
        tx, ty = q.popleft()
        board[tx][ty] = 0
        if cnt in direction_dict:
            turn(direction_dict[cnt])

    else: break

print(cnt)