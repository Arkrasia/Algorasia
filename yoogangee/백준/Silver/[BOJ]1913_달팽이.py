# 백준 1913 달팽이

n = int(input())
m = int(input())

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

table = [[0]*n for _ in range(n)]

x, y = 0, 0
m_x, m_y = 0, 0
d = 0
num = n**2

#print(table)
for i in range(n**2):
    table[x][y] = num
    if num == m:
        m_x = x+1
        m_y = y+1

    num -= 1

    nx = x + dx[d]
    ny = y + dy[d]

    # 큰수부터 출력 다음 자리가 0보다 작거나, n보다 크거나, 다른 숫자로 채워져있으면 방향 변경
    if nx < 0 or nx >= n or ny < 0 or ny >=n or table[nx][ny] != 0:
        d = (d+1)%4
    
    x = x + dx[d]
    y = y + dy[d]
    

for i in range(n):
    for j in range(n):
        print(table[i][j], end=' ')
    print("")
print(m_x, m_y)