from itertools import combinations
import sys;input = sys.stdin.readline
n, s = map(int, input().split())
arr = list(map(int, input().split()))
ans = 0
for i in range(1, n+1):
    c = combinations(arr, i)
    for i in c:
        if sum(i) == s:
            ans += 1
print(ans)