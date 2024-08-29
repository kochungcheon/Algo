import sys
input = sys.stdin.readline
N, M = map(int, input().split()) # N 배열의 크기, M 연산 횟수
arr = [[0]*(M+1)]+ [[0] + list(map(int, input().split())) for _ in range(N)] # 배열의 크기 + 1 만큼 생성, 0은 패딩
prefix = [[0 for _ in range(M+1)] for _ in range(N+1)] # 누적합
for i in range(1,N+1): # 2차원 배열 누적합
    for j in range(1,M+1):
        prefix[i][j] = prefix[i][j-1] + prefix[i-1][j] + arr[i][j] - prefix[i-1][j-1]
ans = -1e9
for x1 in range(1,N+1):
    for y1 in range(1, M+1):
        for x2 in range(x1, N+1):
            for y2 in range(y1, M+1):
                ans = max(ans, prefix[x2][y2]-prefix[x1-1][y2]-prefix[x2][y1-1]+prefix[x1-1][y1-1])

print(ans)