# 백준 1030 프렉탈 평면
import sys
input = sys.stdin.readline

def check_board(l, point):
    x, y = point
    bolck = l//n
    
    if l == 1:
        return 0
    
    if bolck * (n-k)//2 <= x < bolck * (n+k)//2 and bolck * (n-k)//2 <= y < bolck * (n+k)//2:
        return 1
    
    l = l//n
    x %= bolck
    y %= bolck
    return check_board(l, (x,y))

s, n, k, r1, r2, c1, c2 = map(int, input().rstrip().split())
l = n**s

for r in range(r1, r2+1):
    for c in range(c1, c2+1):
        print(check_board(l, (r, c)), end='')
    print()