# 백준 1976 여행가자
import sys
input = sys.stdin.readline


n = int(input())
m = int(input())

city = [list(map(int, input().split())) for _ in range(n)]
plan = list(map(int, input().split()))

bfs_visit = [0]*n
def bfs(start):
    queue = [start]
    bfs_visit[start] = 1 #방문
    while queue: 
        start = queue.pop(0)
        for i in range(n):
            if(city[start][i] == 1 and bfs_visit[i] == 0):
                queue.append(i)
                bfs_visit[i] = 1 #방문

bfs(plan[0]-1)

flag = True
for i in plan:
    if bfs_visit[i-1]==0:
        flag = False

if flag: print("YES")
else: print("NO")