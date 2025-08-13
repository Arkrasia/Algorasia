# 백준 13335 트럭
from collections import deque
n, w, l = map(int, input().split()) # n : 트럭 개수 w: 다리 길이 l: 최대 하중  
truk = list(map(int, input().split()))

bridge = deque([0]*w)
i = 0
time = 0
while True: 
    bridge.popleft()
    if i<=len(truk)-1:
        if (sum(bridge) + truk[i] <= l):
            bridge.append(truk[i]) 
            i += 1 
            time += 1
        else: 
            bridge.append(0)
            time += 1
    else: 
        bridge.append(0)
        time += 1

    if sum(bridge) == 0: 
        print(time)
        break