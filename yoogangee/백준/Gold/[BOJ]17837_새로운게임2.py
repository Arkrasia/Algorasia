# 백준 17837 새로운 게임 2
import sys
input = sys.stdin.readline
from collections import deque

dx = [0,0,-1,1]
dy = [1,-1,0,0]

n, k = map(int, input().split())

colorInfo =[ list(map(int,input().split())) for _ in range(n)]
chessBoard = [[deque() for _ in range(n)] for _ in range(n)]
chessInfo = dict()

for i in range(1, k+1):
    x,y,d = map(int, input().split())
    chessInfo[i] = [x-1, y-1, d-1]
    chessBoard[x-1][y-1].append(i)

def go(i, x, y, d):
    nx = x + dx[d]
    ny = y + dy[d]
    if nx < 0 or ny < 0 or nx >= n or ny >= n or colorInfo[nx][ny] == 2:
        if d == 0 or d == 1:
            d = int(not bool(d))
        else:
            if d == 2:
                d = 3
            else:
                d = 2
        chessInfo[i][2] = d
        nx = x + dx[d]
        ny = y + dy[d]
        if nx < 0 or ny < 0 or nx >= n or ny >= n or colorInfo[nx][ny] == 2:
            return
        
    start = chessBoard[x][y].index(i)
    moveArr = list(chessBoard[x][y])[start:]
    for a in moveArr:
        chessInfo[a] = [nx,ny,chessInfo[a][2]]

    if colorInfo[nx][ny] == 0:
        chessBoard[nx][ny] += moveArr
    elif colorInfo[nx][ny] == 1:
        chessBoard[nx][ny] += moveArr[::-1]
    chessBoard[x][y] = deque(list(chessBoard[x][y])[:start])

    if len(chessBoard[nx][ny]) >= 4:
        return True
    return False

t = 0
while t < 1000:
    t += 1
    overFour = False
    for i in range(1,k+1):
        x,y,d = chessInfo[i]
        if go(i, x, y, d):
            overFour = True
            break
    if overFour:
        break

if t == 1000:
    print(-1)
else:
    print(t)