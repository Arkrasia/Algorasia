# 백준 1966 프린터큐

import sys
input=sys.stdin.readline

from collections import deque

n = int(input())

for _ in range(n):
    i, find = map(int, input().split())
    q = deque(map(int, input().split()))
    count = 0

    while q:
        max_value = max(q)
        current = q.popleft()

        if current == max_value:
            count += 1
            if find == 0:
                print(count)
                break
            else: find -= 1
        
        else:
            q.append(current)
            if find == 0:
                find = len(q)-1
            else:
                find -= 1