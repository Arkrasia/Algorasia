# 백준 2638 치즈
import sys
input = sys.stdin.readline

from collections import deque

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

#공기 탐색
def air_bfs(i,j):
    q = deque()
    q.append([i,j])
    visited[i][j]=1

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
            	#다음이 공기
                if visited[nx][ny]==0 and board[nx][ny]==0:
                    q.append([nx,ny])
                    visited[nx][ny] = 1
                #다음이 치즈
                elif board[nx][ny] == 1:
                    visited[nx][ny] = visited[nx][ny] + 1


dx = [-1,1,0,0]
dy = [0,0,-1,1]
time = 0

while 1:
    visited=[[0 for _ in range(m)] for _ in range(n)]

    air_bfs(0,0)
    #끝나고 시간+1
    time += 1
	
    #치즈 녹음
    for i in range(n):
        for j in range(m):
            if visited[i][j] >= 2:
                board[i][j] = 0

    #공기
    block_cnt = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == 0:
                block_cnt += 1

    if block_cnt == (n*m):
        break
    

print(time)