# 백준 1049 기타줄
n, m = map(int, input().split())

package, single = [], []
for _ in range(m):
    a, b = map(int, input().split())
    package.append(a)
    single.append(b)

min_p = min(package)
min_s = min(single)

print(min(n//6 * min_p + n%6 * min_s, (n//6+1) * min_p, n * min_s))