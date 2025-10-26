# 백준 10819 차이를 최대로
import itertools
n = int(input())
arr = list(map(int, input().split()))

per = itertools.permutations(arr)

ans = 0
for p in per:
    s = 0
    for i in range(n-1):
        s += abs(p[i]-p[i+1])
    
    if ans < s:
        ans = s
print(ans)