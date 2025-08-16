# 백준 10546 배부른 마라토너
import sys
input = sys.stdin.readline

n = int(input())
list = dict()

for _ in range(n):
    name = input().rstrip()
    if name in list:
        list[name] += 1
    else:
        list[name] = 1

for _ in range(n-1):
    name = input().rstrip()
    list[name] -= 1

for n in list:
    if list[n] == 1:
        print(n)
        break

