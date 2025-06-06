#백준 1920 수찾기

N = int(input())
n_array = list(map(int, input().split()))
M = int(input())
m_array = list(map(int, input().split()))
n_array.sort()

for m in m_array:
    lt, rt = 0, N-1
    flag = 0

    #이진탐색 시작
    while lt <= rt: 
        mid = (lt+rt)//2
        if m == n_array[mid]:
            flag = 1
            print(1)
            break
        elif m > n_array[mid]:
            lt = mid + 1
        else:
            rt = mid - 1
    
    if not flag:
        print(0)
