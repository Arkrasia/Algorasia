# 백준 17413 단어 뒤집기
from collections import deque
import sys
input = sys.stdin.readline

s = input().rstrip()
q = deque()
isTag = 0
ans = ""

for i in s:
    if i == "<":
        while q:
            ans += q.pop()
        q.append(i)
        isTag = 1

    elif i == ">":
        q.append(i)
        while q:
            ans += q.popleft()
        isTag = 0

    elif i == " " and isTag == 0:
        while q:
            ans += q.pop()
        ans += " "

    else:
        q.append(i)

while q:
    ans += q.pop()

print(ans)
        