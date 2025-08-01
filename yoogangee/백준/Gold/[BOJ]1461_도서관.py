# 백준 1461 도서관
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
books = list(map(int, input().split()))
ans = 0
#books.append(0)
# [-37 2 -6 -39 -29 11 -28]
negative, positive = [], []
for book in books:
    if book > 0: positive.append(book)
    else: negative.append(book)

positive.sort(reverse=True) #[11, 2]
negative.sort() #[-39, -37, -29, -28, -6]
# (-39, -37), (-29, -28) (2,11) -6
# 39+(29+11+6)*2

distance = []
len_p = len(positive)
for i in range(len_p//m):
    distance.append(abs(positive[i*m]))
if len_p%m != 0:
    distance.append(abs(positive[len_p//m*m]))

len_n = len(negative)
for i in range(len_n//m):
    distance.append(abs(negative[i*m]))
if len_n%m != 0:
    distance.append(abs(negative[len_n//m*m]))

#print(distance)
distance.sort()
max_distance = distance.pop()

print(max_distance+sum(distance)*2)
