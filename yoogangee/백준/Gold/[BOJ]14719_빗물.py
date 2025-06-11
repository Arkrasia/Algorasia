# 백준 14719 빗물

x, y = map(int, input().split())
map = list(map(int, input().split()))

ans = 0

for i in range(1, len(map)-1): 
    left_max = max(map[:i])
    right_max = max(map[i+1:])

    standard = min(left_max, right_max)

    if standard > map[i]:
        ans += standard - map[i]

print(ans)

