# 백준 5430 AC
import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    p = input().rstrip()
    n = int(input())
    arr = deque(input().rstrip()[1:-1].split(','))
    #print(arr)

    if n == 0:
        arr = deque()

    flag = 0
    R = 0
    for i in p:
        if i == 'R':
            R += 1
        elif i == 'D':
            if not arr:
                print('error')
                flag = 1
                break
            else:
                if R % 2 == 0: # 짝수번 돌림 -> 왼쪽값 pop
                    arr.popleft()
                else: # 홀수번 돌림 -> 오른쪽 값 pop
                    arr.pop()

    if flag == 0:
        if R % 2 == 0:
            print('[' + ",".join(arr) + ']')
        else:
            arr.reverse()
            print('[' + ",".join(arr) + ']')