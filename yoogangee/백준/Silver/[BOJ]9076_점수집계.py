n = int(input())

for _ in range(n):
    arr = list(map(int, input().split()))
    arr.sort()
    if arr[3] - arr[1] >= 4:
        print("KIN")
    else:
        print(sum(arr[1:4]))