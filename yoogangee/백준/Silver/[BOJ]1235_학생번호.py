# 백준 1235 학생번호

n = int(input())
student = [input() for _ in range(n)]

for i in range(1, len(student[0])+1):
    result = []
    for j in range(n):
        if student[j][-i:] in result:
            break
        else:
            result.append(student[j][-i:])

    if len(result) == n:
        print(i)
        break

