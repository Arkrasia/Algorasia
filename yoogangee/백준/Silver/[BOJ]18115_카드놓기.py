# 백준 18115 카드놓기
import sys
input = sys.stdin.readline
from collections import deque

n = int(input())
arr = deque(map(int, input().split()))
after = deque(range(1, n+1))
ans = deque()

while arr:
    a = arr.pop()
    card = after.popleft()
    if a == 1:
        ans.appendleft(card)
    elif a == 2:
        ans.insert(1, card)
    else:
        ans.append(card)

print(*ans)