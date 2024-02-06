import sys; input = lambda: sys.stdin.readline().rstrip()
from collections import defaultdict

N = int(input())
di = defaultdict(int)

for i in range(N):
    s, e = map(int, input().split())
    di[s] += 1
    di[e] -= 1

m, cnt = 0, 0
tmp, txm = 0, 0
flag = False
for i in sorted(di.keys()):
    cnt += di[i]
    if cnt > m:
        m = cnt
        tmp = i
        flag = True
    elif cnt < m and cnt - di[i] == m and flag:
        txm = i
        flag = False
print(m)
print(tmp, txm)