# 백준 4889 안정적인 문자열
import sys
input = sys.stdin.readline

cnt = 1
while 1:
    test_case = input().rstrip()
    if test_case[0] == "-":
        break
    
    stack = []
    ans = 0
    for i in test_case:
        if i == '{':
            stack.append(i)
        else:
            if stack:
                stack.pop()
            else:
                ans += 1
                stack.append('{')
    
    ans += len(stack)//2

    print(f'{cnt}. {ans}')
    cnt += 1
