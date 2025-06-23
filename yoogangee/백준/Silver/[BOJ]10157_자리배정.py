# 백준 10157 자리배정
c, r = map(int, input().split())  # 가로, 세로
k = int(input())

# 전체 좌석 수보다 크면 0
if k > c * r:
    print(0)
    exit()

# 아래 → 오른쪽 → 위 → 왼쪽
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1] 

seat = [[0]*c for _ in range(r)]

x, y = 0, 0 
dir = 0      

for num in range(1, c*r + 1):
    seat[x][y] = num

    if num == k:
        print(y + 1, x + 1)
        break

    nx = x + dx[dir]
    ny = y + dy[dir]

    # 경계 또는 이미 채워진 경우 → 방향 전환
    if nx < 0 or nx >= r or ny < 0 or ny >= c or seat[nx][ny] != 0:
        dir = (dir + 1) % 4
        nx = x + dx[dir]
        ny = y + dy[dir]

    x, y = nx, ny
