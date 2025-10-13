import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    max = 0
    ans = ""
    for _ in range(n):
        s, l = input().split()
        l = int(l)
        if (l > max):
            max = l
            ans = s
    print(ans)
