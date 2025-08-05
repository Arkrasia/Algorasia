# 백준 2450 모양정돈
import sys
input = sys.stdin.readline

n = int(input())
shapes = list(map(int, input().split()))
ans = 999999

shapes_num = [0,0,0]
for shape in shapes:
    shapes_num[shape-1] += 1

orders = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
for order in orders:
    arr = []
    for i in order:
        arr += [i]*shapes_num[i-1]

    diff = [[0]*4 for _ in range(4)]
    for i in range(n):
        if shapes[i] != arr[i]:
            diff[shapes[i]][arr[i]] += 1

    cnt = 0
    left = 0
    for i in range(1,4):
        for j in range(1,4):
            tmp = min(diff[i][j], diff[j][i])
            cnt += tmp
            diff[i][j] -= tmp
            diff[j][i] -= tmp

    for i in range(4):
        left += sum(diff[i])    

    cnt += (left//3)*2
    ans = min(ans, cnt)

print(ans)