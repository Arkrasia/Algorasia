# 백준 10868 최솟값
import sys
input = sys.stdin.readline
INF = sys.maxsize

n, m = map(int, input().split())
num = [0]+[int(input()) for _ in range(n)]
tree = [0]*(n*4)


def init(start, end, index):
    if start == end:
        tree[index] = num[start]
        return tree[index]
    
    mid = (start+end)//2
    tree[index] = min(init(start, mid, index*2), init(mid+1, end, index*2+1))
    return tree[index]

def find(start, end, index, left, right):
    if left > end or right < start:
        return INF

    if left <= start and end <= right:
        return tree[index]
    
    mid = (start+end)//2
    return min(find(start, mid, index*2, left, right), find(mid+1, end, index*2+1, left, right))

init(1, n, 1)

for _ in range(m):
    start, end = map(int, input().split())

    print(find(1, n, 1, start, end))
