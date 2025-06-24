# 백준 1388 바닥 장식
n,m = map(int, input().split())

floor = []
for _ in range(n):
    floor.append(list(input()))

cnt = 0
for i in range(n):
    a = ''
    for j in range(m):
        if floor[i][j] == '-':
            if floor[i][j] != a:
                cnt += 1
        a = floor[i][j]

for j in range(m):
    a = ''
    for i in range(n):
        if floor[i][j] == "|":
            if floor[i][j] != a:
                cnt += 1
        a = floor[i][j]

print(cnt)