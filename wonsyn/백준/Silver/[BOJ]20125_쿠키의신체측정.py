import sys
input = sys.stdin.readline

n = int(input())

arr = [input().rstrip() for _ in range(n)]

heart = [0, 0]
flag = False
for i in range(n):
    for j in range(n):
        if arr[i][j] == '*':
            heart[0], heart[1] = i + 1, j
            flag = True
            break
    if flag:
        break

left_arm, right_arm, waist, left_leg, right_leg = 0, 0, 0, 0, 0


def check(r, c):
    return 0 <= r < n and 0 <= c < n


r, c = heart[0], heart[1] - 1
while check(r, c) and arr[r][c] == '*':
    left_arm += 1
    c -= 1

c = heart[1] + 1
while check(r, c) and arr[r][c] == '*':
    right_arm += 1
    c += 1

r, c = heart[0] + 1, heart[1]
while check(r, c) and arr[r][c] == '*':
    waist += 1
    r += 1

low = r
c = heart[1] - 1
while check(r, c) and arr[r][c] == '*':
    left_leg += 1
    r += 1

r = low
c = heart[1] + 1
while check(r, c) and arr[r][c] == '*':
    right_leg += 1
    r += 1

print(heart[0] + 1, heart[1] + 1)
print(left_arm, right_arm, waist, left_leg, right_leg)
