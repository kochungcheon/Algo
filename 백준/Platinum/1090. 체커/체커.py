import sys; 
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
ans = [1<<30] * (N+1)

for i in range(N):
    for j in range(N):
        d = sorted([(abs(arr[i][0]-arr[h][0]) + abs(arr[j][1]-arr[h][1])) for h in range(N)])
        total = 0
        for a in range(N):
            total += d[a]
            ans[a + 1] = min(ans[a + 1], total)

print(*ans[1:])