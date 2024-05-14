import sys; input=sys.stdin.readline
N,M = map(int, input().split())
arr = [0] + list(map(int,input().split()))
prefix = [0] * (N+1)
for i in range(1, N+1):
    prefix[i] = prefix[i-1] + arr[i]

dic = {}
ans = 0

for i in range(N+1):
    ans += dic.get(prefix[i]%M, 0)
    dic[prefix[i]%M] = dic.get(prefix[i]%M, 0) + 1

print(ans)