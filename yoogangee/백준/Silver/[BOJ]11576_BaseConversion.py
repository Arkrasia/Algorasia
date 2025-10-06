a, b = map(int, input().split())

m = int(input())

num = list(map(int, input().split()))
num.reverse()

ten = 0
for i in range(m):
    ten += num[i]*(a**i)

ans = []
while ten//b:
    ans.append(ten%b)
    ten = ten//b
ans.append(ten)

ans.reverse()
print(' '.join(map(str, ans)))
