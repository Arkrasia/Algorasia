# 백준 21608 상어 초등학교
import sys
input = sys.stdin.readline

n = int(input())
sharkClass = [[0]*n for _ in range(n)]
student = n**2
student_num = []
student_like = []
dy = [1, -1, 0, 0]
dx = [0, 0, 1, -1]

for _ in range(student):
    s = list(map(int, input().split()))
    student_num.append(s[0])
    student_like.append(s[1:student])

for i in range(student):
    now_student = student_num[i]
    canSit = []

    for a in range(n):
        for b in range(n):
            if sharkClass[a][b] == 0:
                blank, like = 0, 0

                for index in range(4):
                    na = a + dx[index]
                    nb = b + dy[index]
                    if na<0 or nb<0 or na>=n or nb>=n: continue #칸 넘어가는 경우 예외처리
                    if sharkClass[na][nb] == 0:
                        blank += 1
                    elif sharkClass[na][nb] in student_like[student_num.index(now_student)]:
                        like += 1
                
                canSit.append([a, b, blank, like])
    canSit.sort(key=lambda x: (x[3], x[2], -x[0], -x[1])) #lambda이용 정렬-우선순위: like, blank, i(역순), j(역순)
    a, b, blank, like = canSit.pop()
    sharkClass[a][b] = now_student

ans = 0
for i in range(n):
    for j in range(n):
        like = 0
        a = student_num.index(sharkClass[i][j])
        
        
        for index in range(4):
            ni = i + dx[index]
            nj = j + dy[index]
            if ni<0 or nj<0 or ni>=n or nj>=n: continue #칸 넘어가는 경우 예외처리
            if sharkClass[ni][nj] in student_like[a]:
               like += 1
        
        if like == 0: score = 0
        elif like == 1: score = 1
        elif like == 2: score = 10
        elif like == 3: score = 100
        elif like == 4: score = 1000

        ans += score

print(ans)
