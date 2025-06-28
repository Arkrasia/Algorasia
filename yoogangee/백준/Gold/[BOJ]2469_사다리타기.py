# 백준 2469 사다리 타기

k = int(input())
n = int(input())

end = list(input())
start = sorted(end)

ladder = [list(input()) for _ in range(n)]
for i in range(len(ladder)):
    if ladder[i][0] == "?":
        ladder_start = ladder[:i]
        ladder_end = ladder[i+1:]
        break

for layer in ladder_start:
    for i in range(k-1):
        if layer[i] == "-":
            start[i], start[i+1] = start[i+1], start[i]
#print(start)

ladder_end.reverse()
for layer in ladder_end:
    for i in range(k-1):
        if layer[i] == '-':
            end[i], end[i+1] = end[i+1], end[i]
#print(end)

ans = ""
for i in range(k-1):
    if start[i] == end[i]:
        ans += "*"
    else:
        if start[i] == end[i+1]:
            ans += "-"
        elif i!=0 and start[i] == end[i-1]:
            ans += "*"
        else:
            ans = "x"*(k-1)
            break

print(ans)