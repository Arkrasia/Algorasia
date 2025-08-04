import sys

input = sys.stdin.readline

set = set()

n = int(input())

list = [input().rstrip() for _ in range(n)]

list.sort(key=len, reverse=True)

for i in list:
    flag = False
    for j in set:
        if j.startswith(i):
            flag = True
            break

    if not flag:
        set.add(i)

print(len(set))