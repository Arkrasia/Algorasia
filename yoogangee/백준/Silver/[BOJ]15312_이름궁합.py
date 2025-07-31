# 백준 15312 이름궁합
import sys
input = sys.stdin.readline

A = input().rstrip()
B = input().rstrip()

hint = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]

ans = []
for i in range(len(A)):
    ans.append(hint[ord(A[i])-ord('A')])
    ans.append(hint[ord(B[i])-ord('A')])

#print(name_hint)
while len(ans)!=2:
    tmp = []
    for i in range(len(ans)-1):
        tmp.append((ans[i]+ans[i+1])%10)
        #print(tmp)
    ans = tmp
    tmp = []

print(str(ans[0])+str(ans[1]))