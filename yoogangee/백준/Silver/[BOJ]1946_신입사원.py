# 백준 1946 신입사원

import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    score = []
    # 성적 저장
    for _ in range(n):
        score.append(list(map(int, input().split())))
    
    score.sort()
    top = 0
    cnt = 1
    # for i in range(1, n):
    #     for j in range(i):
    #         if score[i][1] < score[j][1]:
    #             passed = True
    #         else:
    #             passed = False
    #             break

    #     if passed == True:
    #         cnt += 1
    for i in range(1, n):
        if score[top][1] > score[i][1]:
            cnt += 1
            top = i

    print(cnt, end='\n')