# 백준 2075 N번째 큰 수
import heapq

n = int(input())
heap = []

for _ in range(n):
    board = list(map(int, input().split()))
    for i in board:
        if len(heap) < n:
            heapq.heappush(heap, i)
        else:
            if heap[0] < i:
                heapq.heappop(heap)
                heapq.heappush(heap, i)

print(heap[0])