# 백준 33557 곱셈을 누가 이렇게 해 ㅋㅋ
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
        # input
        a, b = input().rstrip().split()
        
        normal = int(a) * int(b)
        
        if len(a) > len(b):
            b = '1' * (len(a) - len(b)) + b
        elif len(b) > len(a):
            a = '1' * (len(b) - len(a)) + a
            
        calc = ''
        for i in range(max(len(a), len(b))):
            calc += str(int(a[i]) * int(b[i]))
        
        print(1 if int(calc) == normal else 0)