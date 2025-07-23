import sys
input = sys.stdin.readline
from collections import deque

N = int(input())
vocab = [input().rstrip() for _ in range(N)]

set = set()

for i in range(N):
    if not set:
        set.add(vocab[i])
        continue

    for j in range(len(vocab[i])):
        if vocab[i] in set:
            flag = True
            break

        dq = deque(vocab[i])
        dq.rotate(1)
        vocab[i] = ''.join(dq)
    else:
        set.add(vocab[i])

print(len(set))