# 백준 2528 사다리
import sys
input = sys.stdin.readline

# 시간 흐름
def time_gone():
    for i in stick:
        if i[3] == 0:
            i[0] += 1
            i[1] += 1
        else:     
            i[0] -= 1
            i[1] -= 1
        if i[3] == 0 and i[1] == l:    
            i[3] = 1
        elif i[3] == 1 and i[0] == 0:   
            i[3] = 0

n, l = map(int, input().split())

stick = [] 
for i in range(n):
    length, way = map(int, input().split())
    if way == 0:      
        stick.append([0, length, i, way]) #시작좌표, 끝좌표, 층, 방향
    else:           
        stick.append([l-length, l , i , way])
#print(stick)
person = 0            
time = 0              
while person < n-1:   
    for i in range(person, n-1):
        #막대기 겹치는 경우
        #낮은층 끝점이 위층 시작점보다 작거나, 낮은층 시작점이 위층 끝점보다 큰 경우 -> 못올라가는 경우 2가지
        if not(stick[i][1] < stick[i+1][0] or stick[i][0] > stick[i+1][1]): 
            person += 1
        else: break
    if person < n-1:
        time_gone()
        time += 1
print(time)