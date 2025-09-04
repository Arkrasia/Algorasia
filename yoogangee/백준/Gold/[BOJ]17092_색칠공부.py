# 백준 17902 색칠공부
import sys
input = sys.stdin.readline
    
h, w, n = map(int, input().split())
    
square = {}
for _ in range(n):
    x, y = map(int, input().split())
        
    for i in range(-2, 1):
        for j in range(-2, 1):
            if 1 <= x+i <= h-2 and 1 <= y+j <= w-2:
                square[(x+i, y+j)] = square.get((x+i, y+j), 0) + 1

three_by_three = [0] * 10
for i in square.values():
    three_by_three[i] += 1

# square 딕셔너리에는 점이 적어도 1개 있는 사각형만 있음
sum = sum(three_by_three[1:])
print((h-2)*(w-2) - sum) # 전체에서 빼줌

for i in range(1, 10):
    print(three_by_three[i])


