# 백준 1918 후위표기식

infix = input()
operator = []
postfix = ""

for i in infix:
    if i == '(':
        operator.append(i)
    elif i == ')':
        while operator[-1] != '(':
            postfix += operator.pop()
        operator.pop()
    elif i == '*' or i == '/':
        while operator and operator[-1] != '(' and (operator[-1] == '*' or operator[-1] == '/'):
            postfix += operator.pop()
        operator.append(i)
    elif i == '+' or i == '-':
        while operator and operator[-1] != '(':
            postfix += operator.pop()
        operator.append(i)
    else:
        postfix += i

while operator: postfix += operator.pop()

print(postfix)