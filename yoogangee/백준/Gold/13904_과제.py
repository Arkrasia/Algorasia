# 백준 13904 과제
n = int(input())
homework = [list(map(int, input().split())) for _ in range(n)]

homework.sort(key = lambda x: x[1], reverse=True)

visited = [False]*1001
score = 0
for d, w in homework:
    while d>0 and visited[d]:
        d -= 1
    if d == 0:
        continue
    else:
        # 점수 높은 과제 나중에 수행
        visited[d] = True
        score += w

print(score)