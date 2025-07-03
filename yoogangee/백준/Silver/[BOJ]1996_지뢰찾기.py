# 백준 1996 지뢰 찾기
import sys
input = sys.stdin.readline

n = int(input().rstrip())
info = [list(input().rstrip()) for _ in range(n)]

dy = [-1, 1, 0, 0, -1, -1, 1, 1]
dx = [0, 0, -1, 1, -1, 1, -1, 1]

for i in range(n):
    for j in range(n):
        if info[i][j] != '.':
            print('*', end='')
        else:
            cnt = 0
            for d in range(8):
                ny = i + dy[d]
                nx = j + dx[d]

                if 0 <= ny < n and 0 <= nx < n and info[ny][nx] != '.':
                    cnt += int(info[ny][nx])
            
            if cnt >= 10:
                print('M', end='')
            else:
                print(cnt, end='')
    print()