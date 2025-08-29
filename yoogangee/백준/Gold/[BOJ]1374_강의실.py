# 백준 1374 강의실
import heapq
import sys
input = sys.stdin.readline

n = int(input())
data = []
for _ in range(n):
    _, start, end = map(int, input().split())
    data.append([start, end])

data.sort()

h = [data[0][1]]
ans = 1
for i in data[1:]:
    if i[0] < h[0]:
        heapq.heappush(h, i[1])
    else:
        heapq.heappop(h)
        heapq.heappush(h, i[1])

print(len(h))