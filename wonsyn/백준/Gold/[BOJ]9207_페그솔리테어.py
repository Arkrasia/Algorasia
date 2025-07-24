import sys
input = sys.stdin.readline

dir = [[-1, 0], [0, 1], [1, 0], [0, -1]]

def move(r, c, total, cnt):
    global min, move_cnt

    if total <= min:
        min, move_cnt = total, cnt

    for d in range(4):
        nr = r + dir[d][0]
        nc = c + dir[d][1]
        if 0 <= nr < 5 and 0 <= nc < 9 and map[nr][nc] == 'o':
            nnr = nr + dir[d][0]
            nnc = nc + dir[d][1]
            if 0 <= nnr < 5 and 0 <= nnc < 9 and map[nnr][nnc] == '.':
                map[r][c] = '.'
                map[nr][nc] = '.'
                map[nnr][nnc] = 'o'
                for i in range(5):
                    for j in range(9):
                        if map[i][j] == 'o':
                            move(i, j, total - 1, cnt + 1)
                map[r][c] = 'o'
                map[nr][nc] = 'o'
                map[nnr][nnc] = '.'

T = int(input())

for t in range(T):
    min = 9
    move_cnt = 0

    total = 0
    map = []
    for i in range(5):
        map.append(list(input().rstrip()))
        total += map[i].count('o')
    input()

    for i in range(5):
        for j in range(9):
            if map[i][j] == 'o':
                move(i, j, total, 0)

    print(min, move_cnt)