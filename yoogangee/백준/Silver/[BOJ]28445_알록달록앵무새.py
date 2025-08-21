import sys
input = sys.stdin.readline

color = set()
for _ in range(2):
    bird = input().rstrip().split()
    for i in bird:
        color.add(i)

color_list = sorted(list(color))

for i in color_list:
    for j in color_list:
        print(i, j)