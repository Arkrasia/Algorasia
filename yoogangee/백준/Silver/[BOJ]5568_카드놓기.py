# 백준 5568 카드 놓기
import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
cards = list(input().rstrip() for _ in range(n))

visited = [0]*n
tmp = []
ans = set()

def card(N):
    if N == k:
        ans.add("".join(tmp))
        return
    
    for i in range(n):
        if visited[i]:
            continue
        visited[i] = 1
        tmp.append(cards[i])

        card(N+1)
        
        visited[i] = 0
        tmp.pop()
        
card(0)
print(len(ans))