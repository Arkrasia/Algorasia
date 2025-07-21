n = int(input())
data = [list(input()) for _ in range(n)]
ans = 0

def check(data):
    max_cnt = 1
    for i in range(n):
        cnt = 1
        for j in range(1, n):
            if data[i][j] == data[i][j-1]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(max_cnt, cnt)

        cnt = 1
        for j in range(1, n):
            if data[j][i] == data[j-1][i]:
                cnt += 1
            else:
                cnt = 1
            max_cnt = max(max_cnt, cnt)
    
    return max_cnt

for i in range(n):
    for j in range(n):
        if j + 1 < n: # 열
            data[i][j], data[i][j+1] = data[i][j+1], data[i][j]
            cnt = check(data)
            ans = max(ans, cnt)
            data[i][j], data[i][j+1] = data[i][j+1], data[i][j] # 원래대로

        if i + 1 < n: # 행
            data[i][j], data[i+1][j] = data[i+1][j], data[i][j]
            cnt = check(data)
            ans = max(ans, cnt)
            data[i][j], data[i+1][j] = data[i+1][j], data[i][j] # 원래대로

print(ans)