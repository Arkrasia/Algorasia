# 백준 14502 연구실

from collections import deque
import copy
from itertools import combinations

# bfs - 바이러스 퍼짐
def bfs(walls):
    lab2 = copy.deepcopy(lab)
    q = deque(virus)  # 미리 저장된 바이러스 위치 사용

    # 벽 세우기
    for x, y in walls:
        lab2[x][y] = 1

    # 바이러스 퍼뜨리기
    while q:
        x, y = q.popleft()
        for t in range(4):
            nx, ny = x + dx[t], y + dy[t]
            if 0 <= nx < n and 0 <= ny < m and lab2[nx][ny] == 0:
                lab2[nx][ny] = 2
                q.append((nx, ny))

    # 안전 영역(0의 개수) 세기
    return sum(row.count(0) for row in lab2)


n,m = map(int, input().split())
lab = [list(map(int, input().split())) for _ in range(n)]

dx,dy = [0,0,1,-1],[1,-1,0,0]
empty = [] #빈칸 위치 저장 리스트
virus = [] #바이러스 위치 저장 리스트
check = [] #안전 구역 수 저장하는 리스트

for i in range(n):
    for j in range(m):
        if lab[i][j] == 0:
            empty.append([i,j])
        elif lab[i][j] == 2:
            virus.append([i,j])

# 조합 사용해 벽 3개
max_safe = 0
for walls in combinations(empty, 3):
    max_safe = max(max_safe, bfs(walls))

print(max_safe)