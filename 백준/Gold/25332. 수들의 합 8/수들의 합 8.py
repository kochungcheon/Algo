import sys;input=sys.stdin.readline
n = int(input())
a = [0] + list(map(int,input().split()))
b = [0] + list(map(int,input().split()))
prefix_a = [0 for _ in range(n+1)]
prefix_b = [0 for _ in range(n+1)]
zero = [0 for _ in range(n+1)]
for i in range(1, n+1):
    prefix_a[i] = prefix_a[i-1] + a[i]
    prefix_b[i] = prefix_b[i-1] + b[i]

for i in range(1, n+1):
    zero[i] = prefix_b[i] - prefix_a[i]

cnt = {}
ans = 0

for i in range(n+1):
    ans += cnt.get(zero[i],0)
    cnt[zero[i]] = cnt.get(zero[i],0) + 1

print(ans)