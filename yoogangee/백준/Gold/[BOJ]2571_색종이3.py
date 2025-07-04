# 뱍쥰 2571 색종이3
import sys
input = sys.stdin.readline

n = int(input())

board = [[0]*110 for _ in range(110)]

for _ in range(n):
    x, y = map(int, input().split())

    for i in range(x, x+10):
        for j in range(y, y+10):
            board[i][j] = 1

for i in range(99):
    for j in range(100):
        if board[i][j] != 0 and board[i+1][j] != 0:
            board[i+1][j] = board[i][j] + 1


answer = 0
for i in range(100):
    for j in range(100):
        h = 100
        for k in range(j, 100):
            h = min(h, board[i][k])
            if h == 0:
                break
        
            answer = max(answer, h * (k-j+1))

print(answer)