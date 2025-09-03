import sys
input = sys.stdin.readline
T = int(input())

for _ in range(T):
    cloth = {}
    ans = 1
    n = int(input())
    for _ in range(n):
        name, type = input().rstrip().split()

        if not type in cloth:
            cloth[type] = 1
        else:
            cloth[type] += 1

    for i in cloth:
        ans *= (cloth[i] + 1)

    print(ans - 1)