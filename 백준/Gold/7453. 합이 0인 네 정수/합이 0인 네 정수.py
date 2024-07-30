import sys; input = sys.stdin.readline
N = int(input())
A = []
B = []
C = []
D = []
for _ in range(N):
    a, b, c, d = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)
ab = {}
for a in A:
    for b in B:
        aplusb = a+b
        ab.setdefault(aplusb, 0)
        ab[aplusb] += 1
ans = 0
for c in C:
    for d in D:
        cplusd = c + d
        ans += ab.get(-cplusd, 0)
print(ans)
