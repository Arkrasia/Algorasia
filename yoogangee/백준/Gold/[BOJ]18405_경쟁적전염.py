# 백준 18405 경쟁적 전염
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
test = [list(map(int, input().split())) for _ in range(n)]
s, x, y = map(int, input().split())

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

virus = [[]]*(k+1)
for i in range(1, k+1):
    tmp = []
    for r in range(n):
        for c in range(n):
            if test[r][c] == i:
                tmp.append([r, c])
    virus[i] = tmp
#print(virus)

def bfs():
    for _ in range(s):
        for i in range(1, k+1):
            tmp = []
            while virus[i]:
                x, y = virus[i].pop()
                for d in range(4): 
                    nx, ny = x+dx[d], y+dy[d]
                    if nx < 0 or nx >= n or ny < 0 or ny >= n: continue
                    if test[nx][ny] == 0:
                        test[nx][ny] = i
                        tmp.append([nx, ny])
            virus[i] = tmp


bfs()

print(test[x-1][y-1])

