# 백준 1091 카드섞기
n = int(input())
p = list(map(int, input().split()))
s = list(map(int, input().split()))

ans = 0
original = p.copy()

while [0,1,2]*(n//3) != p:
    tmp = [0]*n
    for i in range(n):
        tmp[s[i]] = p[i]
    # 카드 섞다가 처음이랑 같으면 종료
    if original == tmp:
        ans = -1
        break
    ans += 1
    p = tmp

print(ans)
