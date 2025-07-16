# 백준 7490 0만들기
import sys
input = sys.stdin.readline

n = int(input())

def operator(depth, ans):
    if depth == tc+1:
        cal_ans = ans.replace(' ','')
        if eval(cal_ans) == 0:
            print(ans)
        return
    
    # 아스키 순서에 따라서
    operator(depth+1, ans+' '+str(depth))
    operator(depth+1, ans+'+'+str(depth))
    operator(depth+1, ans+'-'+str(depth))


for _ in range(n):
    tc = int(input())
    operator(2, '1')
    print()
