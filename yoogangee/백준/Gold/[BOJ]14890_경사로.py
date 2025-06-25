# 백준 14890 경사로
import sys
input = sys.stdin.readline

n, l = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(n)]
cross_map = list(zip(*map)) #전치행렬 만들기

def find(load):
    visit = [False]*n
    for i in range(1, n):
        if abs(load[i]-load[i-1]) > 1:
            return False

        if load[i-1] > load[i]:
            for j in range(l):
                if i+j >= n or load[i] != load[i+j] or visit[i+j]:
                    return False
                elif load[i] == load[i+j]:
                    visit[i+j] = True
            
        elif load[i-1] < load[i]:
            for j in range(l):
                if i-j-1 < 0 or load[i-1] != load[i-j-1] or visit[i-j-1]:
                    return False
                elif load[i-1] == load[i-j-1]:
                    visit[i-j-1] = True
    
    return True


ans = 0
for i in range(n):
    if find(map[i]):
        ans += 1
    if find(cross_map[i]):
        ans += 1
print(ans)