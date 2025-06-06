# 백준 9020 골드바흐의 추측
import sys
input=sys.stdin.readline

def is_Prime(num): # 소수인지 확인하는 함수
    if num == 1: return False
    for i in range(2, int(num**0.5+1)): # 루트값까지만 비교 - 이후로는 비교할 필요 없음
        if num % i == 0:
            return False
    return True

T = int(input())

for _ in range(T):
    n = int(input())
    lt, rt = n/2, n/2

    while lt>0:
        if is_Prime(lt) and is_Prime(rt): 
            print(int(lt), int(rt))
            break
        else: # 소수 아니면 왼쪽값 -1, 오른쪽값 +1
            lt -= 1
            rt += 1