N = int(input())
K = int(input())
s = 0
e = K
ans = 0

while s <= e:
    mid = (s+e)//2
    a = 0

    for i in range(1, N+1):
        a += min(mid//i, N)

    if a >= K:
        ans = mid
        e = mid - 1
    else:
        s = mid + 1

print(ans)