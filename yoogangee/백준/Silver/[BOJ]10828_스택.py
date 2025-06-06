#백준 10828 스택
import sys
input=sys.stdin.readline

N = int(input())
stack = []

def push(p):
    stack.append(p)

def pop():
    print(stack.pop() if stack else -1)

def size():
    print(len(stack))

def empty():
    print(0 if stack else 1)

def top():
    print(stack[-1] if stack else -1)

for _ in range(N):
    command = input().split()
    if command[0]=="push":
        push(command[1])
    elif command[0]=="pop":
        pop()
    elif command[0]=="size":
        size()
    elif command[0]=="empty":
        empty()
    elif command[0]=="top":
        top() 