#백준 15903 카드합체 놀이
from collections import deque

n, m = map(int, input().split())

card = (list(map(int, input().split())))
card.sort() #카드 정렬

q_card = deque(card)

for _ in range(m):
    first_min = q_card.popleft()
    second_min = q_card.popleft()

    for _ in range(2): q_card.append(first_min+second_min)
    q_card = deque(sorted(q_card))


print(sum(q_card))
    