# 백준 9207 페그 솔리테어
import sys
input = sys.stdin.readline

n = int(input())

dy = [1, -1, 0, 0]
dx = [0, 0, 1, -1]

def move_pin(move_num):
    global minpin, min_movenum

    pin = []
    for i in range(5):
        for j in range(9):
            if board[i][j] == "o":
                pin.append((j,i))
    
    if len(pin) < minpin:
        min_movenum = move_num
        minpin = len(pin)

    for x, y in pin:
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if -1<nx+dx[d]<9 and -1<ny+dy[d]<5:
                if board[ny][nx]=="o" and board[ny+dy[d]][nx+dx[d]]==".":
                    board[ny][nx] = "."
                    board[ny+dy[d]][nx+dx[d]]="o"
                    board[y][x]="."
                    move_pin(move_num+1)
                    # 되돌리기
                    board[ny][nx] = "o"
                    board[ny+dy[d]][nx+dx[d]]="."
                    board[y][x]="o"

    


for _ in range(n):
    board = [list(input().rstrip()) for _ in range(5)]
    input()
    minpin = 9
    min_movenum = 9 # 이동횟수 최대 7번
    move_pin(0)
    print(minpin, min_movenum)


