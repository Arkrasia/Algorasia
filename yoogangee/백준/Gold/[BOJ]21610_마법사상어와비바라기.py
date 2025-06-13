# 백준 21610 마법사 상어와 비바라기
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
basket = [list(map(int, input().split())) for _ in range(n)]
#direction = [list(map(int, input().split())) for _ in range(map_y)]

# 이동경로
dy = [9, 0, -1, -1, -1, 0, 1, 1, 1]
dx = [9,-1, -1, 0, 1, 1, 1, 0, -1]
cloud = [[n-1,0],[n-2,0],[n-1,1],[n-2,1]]


for _ in range(m):
    way, distance = map(int, input().split())
    afterMove_cloud = []
    wasCloud = [[0]*n for _ in range(n)] #구름이었던 basket 저장 리스트
    #print(cloud)
    
    # 구름 이동, 비 1씩 내리기
    while cloud:
        y, x = cloud.pop()
        ny, nx = (y + dy[way]*distance) % n, (x + dx[way]*distance) % n #1,n 연결된 것 처리
        afterMove_cloud.append([ny, nx])
        wasCloud[ny][nx] = 1
        basket[ny][nx] += 1
    
    cross = [[-1,-1],[-1,1],[1,1],[1,-1]]
    for ny, nx in afterMove_cloud:   
        for cy, cx in cross :
            if 0 <= ny + cy < n and 0 <= nx + cx < n and basket[ny + cy][nx + cx]:
                basket[ny][nx] += 1
    
    for i in range(n):
        for j in range(n):
            if basket[i][j] >= 2 and not wasCloud[i][j]:
                basket[i][j] -= 2
                cloud.append([i,j])
        

print(sum(map(sum,basket)))