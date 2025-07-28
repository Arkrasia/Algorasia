# 백준 1817 짐챙기는 숌
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
books = list(map(int, input().split()))

if n > 0:
    weight, ans = 0, 1
    for book in books:
        if weight + book <= m:
            weight += book
        else:
            ans += 1
            weight = book
    print(ans)
else:
    print(0)