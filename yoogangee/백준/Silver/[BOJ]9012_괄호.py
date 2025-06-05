T = int(input())

for _ in range(T):
    stack = []
    PS = input()

    for i in PS:
        if i == '(':
            stack.append(i)
        elif i == ')':
            if stack:
                stack.pop()
            else:
                print("NO")
                break

    else: #break 수행x
        if stack:
            print("NO")
        else:
            print("YES")