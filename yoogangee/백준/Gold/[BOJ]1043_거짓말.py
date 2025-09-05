import sys
input = sys.stdin.readline

n, m = map(int, input().split())

parent = [i for i in range(n+1)]
true = list(map(int, input().split()))
parties = [list(map(int, input().split())) for _ in range(m)]

def union(a, b):
    x = find(a)
    y = find(b)
    parent[y] = x

def find(x):
    if parent[x] == x:
        return parent[x]
    parent[x] = find(parent[x])
    return parent[x]

if true[0] == 0:               
    print(m)
    exit()

for i in range(2, len(true)): 
    union(true[1], true[i])

for party in parties:           
    for i in range(2, len(party)):
        union(party[1], party[i])

answer = 0
x = find(true[1])

for party in parties:
    if find(party[1]) != x:
        answer += 1

print(answer)