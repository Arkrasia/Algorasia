import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())

subject = dict()
for _ in range(n):
    s, p = input().rstrip().split()
    subject[s] = int(p)

score = 0
for _ in range(k):
    t = input().rstrip()
    score += subject[t]
    del subject[t]

subject = sorted(subject.items(), key=lambda x: x[1])
max_score, min_score = score, score

for i in range(m-k):
    max_score += subject[i][1]
    min_score += subject[-i-1][1]
print(max_score, min_score)