import sys
input = sys.stdin.readline
from collections import deque

n = int(input())

for _ in range(n):
    num = int(input())
    card = list(map(str, input().rstrip().split()))
    word = deque([card[0]])

    for i in card[1:]:
        if i > word[0]:
            word.append(i)
        else:
            word.appendleft(i)
            
    print("".join(word))