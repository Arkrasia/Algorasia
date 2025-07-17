# 백준 1706 크로스워드
r, c = map(int, input().split())
crossword = [input() for _ in range(r)]

word_list = []
for i in range(r):
    save = crossword[i].split("#")
    for j in save:
        if len(j) > 1:
            word_list.append(j)

new_crossword = list(map(list, zip(*crossword)))
for i in range(c):
    # 뒤집은거는 배열로 들어가있어서 join 써서 문자열로 만들어줌
    save = "".join(new_crossword[i]).split('#') 
    for j in save:
        if len(j) > 1:
            word_list.append(j)

word_list.sort()
print(word_list[0])