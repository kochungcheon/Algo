import sys; input = lambda : sys.stdin.readline().rstrip()


def find(x):
    if par[x] == x:
        return x
    par[x] = find(par[x])
    return par[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    if sz[a] >= sz[b]:
        par[b] = a
        sz[a] += sz[b]
    else:
        par[a] = b
        sz[b] += sz[a]
    


N = int(input())
par = [i for i in range(10**6+1)]
sz = [1 for i in range(10**6+1)]
cmd = [list(input().split()) for _ in range(N)]

for c in cmd:
    if c[0] == 'I':
        union(int(c[1]), int(c[2]))
    else:
        print(sz[find(int(c[1]))])












