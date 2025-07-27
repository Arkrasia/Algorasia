# 백준 20125 쿠키의 신체 측정
import sys
input = sys.stdin.readline

n = int(input())
board = [list(input().rstrip()) for _ in range(n)]

flag = False
x, y = 0, 0

for i in range(n):
    for j in range(n):
        if board[i][j] == "*":
            x = i+2
            y = j+1
            print(x, y)
            flag = True
            break
    if flag:
        break

left_arm = 0
for i in range(y-1):
    if board[x-1][i] == "*": left_arm += 1

right_arm = 0
for i in range(y, n):
    if board[x-1][i] == "*": right_arm += 1

back = 0
back_end = 0
for i in range(x, n):
    if board[i][y-1] == "*":
        back += 1
        back_end = i

left_leg = 0
for i in range(n-1, back_end, -1):
    if board[i][y-2] == "*": left_leg += 1

right_leg = 0
for i in range(n-1, back_end, -1):
    if board[i][y] == "*": right_leg += 1

print(left_arm, right_arm, back, left_leg, right_leg)