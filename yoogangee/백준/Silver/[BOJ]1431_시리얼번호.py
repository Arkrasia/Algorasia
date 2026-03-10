# 백준 1431 시리얼 번호
n = int(input())

arr = [input() for _ in range(n)]

def sum_num(serial):
    result = 0
    for i in serial:
        if i.isdigit():
            result += int(i)
    return result

arr.sort(key=lambda x: (len(x), sum_num(x), x))

for i in arr: print(i)