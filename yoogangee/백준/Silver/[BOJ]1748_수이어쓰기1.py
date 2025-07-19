n = input()
ans = 0

for i in range(1, len(n)):
    ans += i*9*10**(i-1)

ans += (int(n)-10**(len(n)-1)+1)*len(n)

print(ans)