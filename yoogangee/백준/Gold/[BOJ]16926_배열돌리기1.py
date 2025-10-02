# 백준 16929 배열 돌리기 1
import sys
from collections import deque
input = sys.stdin.readline

n, m, r = map(int, input().split())

matrix = []
answer = [[0]*m for _ in range(n)]
q = deque()

for i in range(n):
    matrix.append(list(input().split()))

for i in range(min(n, m)//2):
    q.clear()
    q.extend(matrix[i][i:m-i])
    q.extend([row[m-i-1] for row in matrix[i+1:n-i-1]])
    q.extend(matrix[n-i-1][i:m-i][::-1])
    q.extend([row[i] for row in matrix[i+1:n-i-1]][::-1])
    
    q.rotate(-r)
    
    for j in range(i, m-i):                 # 위쪽
        answer[i][j] = q.popleft()
    for j in range(i+1, n-i-1):             # 오른쪽
        answer[j][m-i-1] = q.popleft()
    for j in range(m-i-1, i-1, -1):           # 아래쪽
        answer[n-i-1][j] = q.popleft()  
    for j in range(n-i-2, i, -1):           # 왼쪽
        answer[j][i] = q.popleft()    

for line in answer:
    print(" ".join(line))
