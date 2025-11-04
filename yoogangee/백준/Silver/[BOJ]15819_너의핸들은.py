# 백준 15819 너의 핸들은
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
ids = [input().rstrip() for _ in range(n)]
ids.sort()

print(ids[m-1])