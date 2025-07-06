# 백준 1652 누울자리를 찾아라

n = int(input())
room = [input() for _ in range(n)]

rows = 0
for i in range(n):
    cnt = 0
    for j in range(n):
        if room[i][j] == ".":
            cnt += 1
            if cnt == 2:
                rows += 1
        else:
            cnt = 0
            continue

columns = 0
for i in range(n):
    cnt = 0
    for j in range(n):
        if room[j][i] == ".":
            cnt += 1
            if cnt == 2:
                columns += 1
            
        else:
            cnt = 0
            continue

print(rows, columns)