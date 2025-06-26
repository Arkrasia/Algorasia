# 백준 15720 카우버거

b, c, d = map(int, input().split())

burger = list(map(int, input().split()))
side = list(map(int, input().split()))
drink = list(map(int, input().split()))

burger.sort(reverse=True)
side.sort(reverse=True)
drink.sort(reverse=True)

min_num = min(b, c, d)
set_sum = 0
for i in range(min_num):
    set_sum += (burger[i]+side[i]+drink[i])* 0.9

set_sum += sum(burger[min_num::])
set_sum += sum(side[min_num::])
set_sum += sum(drink[min_num::])

print(sum(burger)+sum(side)+sum(drink))
print(int(set_sum))
