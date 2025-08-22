# 백준 20055 컨베이어 벨트 위의 로봇
import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
belt = deque(map(int, input().split()))
robots = deque([0]*n)

ans = 0
while True:
    ans += 1
    # 1.
    belt.rotate(1)
    robots.rotate(1)

    robots[-1] = 0
    # 2.
    for i in range(n-2, -1, -1):
        if robots[i]==1 and robots[i+1]==0 and belt[i+1]>=1:
            robots[i+1] = 1
            robots[i] = 0
            belt[i+1] -= 1
    robots[-1] = 0
    # 3.
    if belt[0] != 0 and robots[0] != 1:
        robots[0] += 1
        belt[0] -= 1
    # 4.
    if belt.count(0) >= k:
        break

print(ans)