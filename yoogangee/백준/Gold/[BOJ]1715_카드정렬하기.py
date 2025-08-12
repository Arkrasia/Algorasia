# 백준 1715 카드 정렬하기
import sys
import heapq
input = sys.stdin.readline

n = int(input())
cards = []

for _ in range(n):
    heapq.heappush(cards, int(input()))

ans = 0
if len(cards) == 1:
    print(ans)
else:
    for _ in range(n-1):
        pre = heapq.heappop(cards)
        now = heapq.heappop(cards)
        
        ans += pre + now
        heapq.heappush(cards, pre+now)
    print(ans)
