# 백준 10973 이전 순열
n = int(input())
p = list(map(int, input().split()))

for i in range(n-1, 0, -1):
    if p[i] < p[i-1]:
        x, y = i-1, i
        for j in range(n-1, 0, -1):
            if p[j] < p[x]:
                p[j], p[x] = p[x], p[j]
                p = p[:i] + sorted(p[i:], reverse=True)
                print(*p)
                exit(0)
print(-1)

