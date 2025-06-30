# 백준 1417 국회의원 선거
import sys
input = sys.stdin.readline

n = int(input())
dasom = int(input())
vote = [int(input()) for _ in range(n-1)]
cnt = 0

if (n==1):
    pass
else:
    while dasom <= max(vote):
        dasom += 1
        cnt += 1
        vote[vote.index(max(vote))] -= 1

print(cnt)