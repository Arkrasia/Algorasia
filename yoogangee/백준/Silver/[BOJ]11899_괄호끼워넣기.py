# 백준 11899 괄호 끼워 넣기
import sys
input = sys.stdin.readline

s = input().rstrip()
stack = []

for char in s:
  if char == ')':
    if stack and stack[-1] == '(':
      stack.pop()
    else:
      stack.append(char)
  else:
    stack.append(char)

print(len(stack))
