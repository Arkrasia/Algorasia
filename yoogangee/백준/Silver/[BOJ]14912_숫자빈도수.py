# 백준 14912 숫자 빈도 수

ans = 0

num, find = map(int, input().split())
for i in range(1, num+1):
    ans += str(i).count(str(find))

print(ans)
