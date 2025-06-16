# 백준 20056 마법사상어와파이어볼
#  i번 파이어볼의 위치는 (ri, ci), 질량은 mi이고, 방향은 di, 속력은 si이다. 위치 (r, c)는 r행 c열을 의미한다.
# 다섯 정수 ri, ci, mi, si, di
import sys
input = sys.stdin.readline

n, m, k = map(int, input().split()) # nxn 격자, m개 파이어볼, k번 이동
board = [[[] for _ in range(n)] for _ in range(n)]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, 1, 1, 1, 0, -1, -1, -1]

fireball = []
for _ in range(m):
    r, c, m, s, d = map(int, input().split())
    fireball.append([r-1, c-1, m, s, d])

for _ in range(k):
    # 파이어볼 이동
    while fireball:
        fr, fc, fm, fs, fd = fireball.pop(0)
        # 행, 열 연결처리
        nr = (fr + fs * dy[fd]) % n
        nc = (fc + fs * dx[fd]) % n
        board[nr][nc].append([fm, fs, fd])
    
    
    for r in range(n):
        for c in range(n):
            # 2개 이상일때 처리
            if len(board[r][c]) > 1:
                sum_m, sum_s, cnt_odd, cnt_even, cnt = 0, 0, 0, 0, len(board[r][c])
                while board[r][c]:
                    m, s, d = board[r][c].pop(0)
                    sum_m += m
                    sum_s += s
                    if d % 2 == 0:
                        cnt_even += 1
                    else:
                        cnt_odd += 1

                # 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.
                if cnt_odd == cnt or cnt_even == cnt:
                    nd = [0, 2, 4, 6]
                else:
                    nd = [1, 3, 5, 7]

                if sum_m//5 != 0: #질량 0아닐때만 fireball에 append
                    for d in nd:
                        fireball.append([r, c, sum_m//5, sum_s//cnt, d])

            # 1개만 있을때
            elif len(board[r][c]) == 1:
                fireball.append([r, c] + board[r][c].pop())
    #print(fireball)

print(sum([f[2] for f in fireball]))

