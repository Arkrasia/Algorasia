# 백준 14891 톱니바퀴
from collections import deque

def right(idx, d):
    if idx > 3:
        return
    if sawtooth[idx - 1][2] != sawtooth[idx][6]:
        right(idx + 1, -d)
        sawtooth[idx].rotate(d)

def left(idx, d):
    if idx < 0:
        return
    if sawtooth[idx][2] != sawtooth[idx + 1][6]:
        left(idx - 1, -d)
        sawtooth[idx].rotate(d)

sawtooth = [deque(list(map(int, input()))) for _ in range(4)]
k = int(input())

for _ in range(k):
    idx, d = map(int, input().split())
    idx -= 1
    left(idx - 1, -d)
    right(idx + 1, -d)

    sawtooth[idx].rotate(d)

ans = 0
for i in range(4):
    if sawtooth[i][0] == 1:
        ans += 2 ** i

print(ans)