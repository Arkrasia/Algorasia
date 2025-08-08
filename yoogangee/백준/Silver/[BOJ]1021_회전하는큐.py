# 백준 1021 회전하는 큐
from collections import deque

n, m = map(int, input().split())
num = list(map(int, input().split()))
dq = deque([i for i in range(1, n+1)])

cnt = 0
for n in num:
    while True:
        if dq[0] == n:
            dq.popleft()
            break
        else:
            if dq.index(n) < len(dq)/2:
                while dq[0] != n:
                    dq.rotate(-1)
                    cnt += 1
            else:
                while dq[0] != n:
                    dq.rotate(1)
                    cnt += 1

print(cnt)
