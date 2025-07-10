# 백준 18808 스티커 붙이기
import sys
input = sys.stdin.readline

# 노트북에서 스티커 붙일 수 있는 위치 찾는  함수
def find(x, y, sticker, r, c):
    for i in range(x, x+r):
        for j in range(y, y+c):
            if notebook[i][j] and sticker[i-x][j-y]: # 노트북에 이미 값있음 & 스티커 값도 있음 - 못붙임 !
                return False
    for i in range(x, x+r): 
        for j in range(y, y+c):
            if sticker[i-x][j-y]: # False return 안됐고, 스티커 값 있으면 값 1로 바꿈 (스티커 붙이기)
                notebook[i][j] = 1
    return True 

# 스티커 붙일 수 있는 지 확인하는 함수
def check(sticker, r, c):
    for i in range(n-r+1):
        for j in range(m-c+1):
            if find(i, j, sticker, r, c): # 스티커 붙일 수 있어서 붙였으면 True
                return True 
    return False


# 90도 돌리는 함수
def rotate(s):
    return list(map(list, zip(*s[::-1])))


# n,m - 노트북 세로, 가로 / k - 스티커 개수
n, m, k = map(int, input().split()) 

notebook = [[0]*m for _ in range(n)]
for _ in range(k):
    r, c = map(int, input().split())
    sticker = [list(map(int, input().split())) for _ in range(r)]

    canAttach = False
    for _ in range(4):
        if check(sticker, r, c): #노트북에 넣을수 있으면
            break
        else:
            sticker = rotate(sticker)
            r, c = c, r # 돌아갔으니깐


print(sum(sum(i) for i in notebook))