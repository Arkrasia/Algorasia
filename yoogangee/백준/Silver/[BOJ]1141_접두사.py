# 백준 1141 접두사
import sys
input = sys.stdin.readline

n = int(input())
words = [input().rstrip() for _ in range(n)]

words.sort(key=len)

ans = n
for i in range(n):
    for j in range(i+1, n):
       if words[i] == words[j][:len(words[i])]:
           ans -= 1
           break
           
print(ans)
