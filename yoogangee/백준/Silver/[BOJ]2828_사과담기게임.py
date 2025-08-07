# 백준 2828 사과 담기 게임
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
j = int(input())
apples = list(int(input()) for _ in range(j))

now = 1
ans = 0
for apple in apples:
    if now <= apple and now + (m-1) >= apple:
        pass
    elif now > apple:
        ans += abs(apple - now)
        now = apple
    else:
        ans += apple - (m-1) - now
        now = apple - (m-1)

print(ans)