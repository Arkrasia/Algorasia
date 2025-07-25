import sys
input = sys.stdin.readline

rom_to_arab = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
arab_to_rome = {1:'I', 5:'V', 10:'X', 50:'L', 100:'C', 500:'D', 1000:'M'}

def to_arab(s):
    sum = 0

    for i in range(len(s) - 1):
        if rom_to_arab[s[i]] < rom_to_arab[s[i + 1]]:
            sum -= rom_to_arab[s[i]]
        else:
            sum += rom_to_arab[s[i]]
    sum += rom_to_arab[s[-1]]
    return sum

def to_rome(num):
    res = []

    temp = 1000
    while(temp != 0):
        div = num // temp
        c = arab_to_rome[temp]
        if div < 4:
            for _ in range(div):
                res.append(c)
        elif div == 4:
            res.append(c)
            res.append(arab_to_rome[temp * 5])
        elif div < 9:
            res.append(arab_to_rome[temp * 5])
            for _ in range(div - 5):
                res.append(c)
        elif div == 9:
            res.append(c)
            res.append(arab_to_rome[temp * 10])
        num %= temp
        temp //= 10

    return "".join(res)

n1 = input().rstrip()
n2 = input().rstrip()

sum = to_arab(n1) + to_arab(n2)
print(sum)
print(to_rome(sum))