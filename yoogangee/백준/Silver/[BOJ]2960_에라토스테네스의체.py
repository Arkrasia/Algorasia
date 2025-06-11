# 백준 2960 에라토스테네스의체

N, K = map(int, input().split())
tmp = 0

arr = [True] * (N + 1)
for i in range(2, N + 1):
    for j in range(i, N + 1, i):
        if arr[j] == True:
            arr[j] = False
            tmp += 1
            if tmp == K:
                print(j)