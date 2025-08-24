import sys
from collections import deque
input = sys.stdin.readline

ans = 0
n = int(input())
q = deque()

for i in range(n*2):
    if i < n:
        q.append(input().rstrip())
    else:
        out = input().rstrip()
        if out != q[0]:
            q.remove(out)
            ans += 1
        else:
            q.popleft()

print(ans)