# 백준 1722 순열의 순서
n = int(input())

data = list(map(int, input().split()))

facList = [0]*21
facList[0] = 1
for i in range(1,n+1):
    facList[i] = facList[i-1]*i

# 3
def findP(num):
    global n # 지역변수 오류떠서
    k = num-1
    numList = list(range(1, n+1))
    ansP = []

    while n > 0:
        idx = k // facList[n-1]
        ansP.append(numList.pop(idx))
        k %= facList[n-1]
        n -= 1
    
    print(" ".join(map(str, ansP)))


# [1, 3, 2, 4]
def findNum(p):
    ans = 0
    numList = list(range(1, n+1))
    for i in range(n):
        idx = numList.index(p[i])
        ans += idx * facList[n-i-1]
        numList.pop(idx)
    print(ans+1)

if data[0]==1:
    findP(data[1])
elif data[0]==2:
    findNum(data[1::])