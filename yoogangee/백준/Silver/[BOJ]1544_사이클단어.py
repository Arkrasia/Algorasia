import sys
input = sys.stdin.readline
from collections import deque #이걸로 큐 써 보통

n = int(input())
vocab = [input().rstrip() for _ in range(n)]
#print(vocab)

def rotate(word1, word2):
    if len(word1) != len(word2): return word2 #길이 다르면 다른 단어
    word2_q = deque(word2)

    for _ in range(len(word1)):
        word2_q.rotate(1) #이게 회전시키는거임 한칸씩 
        tmp = ''.join(word2_q)
        if word1 == tmp: return tmp

    return word2

for i in range(n):
    for j in range(i, n):
        if vocab[i] != vocab[j]:
            vocab[j] = rotate(vocab[i], vocab[j]) #사이클 단어면 원래단어랑 같게 바뀜


print(len(set(vocab))) # 겹치는거 없애서 출력

