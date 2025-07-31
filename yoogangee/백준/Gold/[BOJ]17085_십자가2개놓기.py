# 백준 17085 십자가 2개 놓기
import sys
input = sys.stdin.readline

dy = [1, -1, 0, 0]
dx = [0, 0, -1, 1]

def get_size(a, b):
    size = 0
    while 1:
        flag = True
        for d in range(4):
            ny = a + dy[d]*size
            nx = b + dx[d]*size
            if ny < 0 or ny >= n or nx < 0 or nx >= m or board[ny][nx] != "#":
                flag = False
                break
        if flag: size += 1
        else: break
    return size-1

def make_cross(a, b, size, cross):
    for i in range(size+1):
        for j in range(4):
            cy = a + dy[j]*i
            cx = b + dx[j]*i
            board[cy][cx] = cross

n, m = map(int, input().split())
board = [list(input().rstrip()) for _ in range(n)]
ans = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == "#":
            first = get_size(i, j)
            for f in range(first+1):
                make_cross(i, j, f, '*')
            
                for r in range(n):
                    for c in range(m):
                        if board[r][c] == "#":
                            second = get_size(r, c)
                            area1 = 4*f + 1
                            area2 = 4*second + 1
                            ans = max(ans, area1*area2)
                make_cross(i, j, first, "#") # 처음 십자가 원래대로            
print(ans)

