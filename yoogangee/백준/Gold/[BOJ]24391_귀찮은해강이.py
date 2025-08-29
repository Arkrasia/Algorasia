# 백준 24391 귀찮은 해강이
import sys
input=sys.stdin.readline

def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)

    if a > b:
        parent[a] = b
    else:
        parent[b] = a

n, m = map(int,input().split())

parent = [0]*(n+1)

for i in range(1,n+1):
    parent[i] = i


for i in range(m):
    a, b = map(int,input().split())
    union(a, b)

schedule = list(map(int,input().split()))
ans = 0
for i in range(1,len(schedule)):
    if find(schedule[i-1]) != find(schedule[i]):
        ans+=1
print(ans)