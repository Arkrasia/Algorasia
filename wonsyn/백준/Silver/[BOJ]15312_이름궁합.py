import sys

input = sys.stdin.readline
from collections import deque

cnt = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]

A = input().rstrip()
B = input().rstrip()

dict = {}
for i in range(len(cnt)):
    dict[chr(ord("A") + i)] = cnt[i]

dq = deque()
for i in range(len(A)):
    dq.append(dict[A[i]])
    dq.append(dict[B[i]])


while len(dq) > 2:
    temp = deque()
    a = dq.popleft()

    while dq:
        b = dq.popleft()
        temp.append((a + b) % 10)
        a = b

    dq = temp

print(str(dq.popleft()) + str(dq.popleft()))
