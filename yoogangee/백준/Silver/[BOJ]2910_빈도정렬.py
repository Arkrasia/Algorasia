# 백준 2910 빈도 정렬
n, c = map(int, input().split())
nums = list(map(int, input().split()))

dict = {} #[등장순서, 빈도수]
idx = 1
for num in nums:
    if num in dict:
        dict[num][1] += 1
    else:
        dict[num] = [idx, 1, num]
        idx += 1
    
sorted_num = sorted(dict.values(), key=lambda x: (-x[1], x[0])) # 빈도수 내림차순, 등장순서 오름차순 정렬
#print(sorted_num)    

ans = []
for i in sorted_num:
    for j in range(i[1]):
        ans.append(i[2])

print(" ".join(map(str, ans)))