n = int(input())
calendar = [0]*367

for _ in range(n):
    start, end = map(int, input().split())
    calendar[start] += 1
    calendar[end+1] -= 1
 
width = 0
height = 0
ans = 0
for i in range(1, 367):
    calendar[i] += calendar[i-1]
    if calendar[i] == 0:
        ans += width*height
        width = 0
        height = 0
    else:
        width += 1
        height = max(height, calendar[i])
 
print(ans)