# 백준 2204 도비의 난독증 테스트

while True:
    n = int(input())

    if n == 0:
        break

    arr = [input() for _ in range(n)]

    arr.sort(key=str.lower)
    print(arr[0])
    