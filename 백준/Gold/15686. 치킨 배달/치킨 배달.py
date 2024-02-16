import sys; input = sys.stdin.readline
def recur(cur, start):
    global ans
    if cur > M:
        return

    if cur == M:                    # 고른 것의 치킨 거리를 골라줌
        total = 0
        for i in range(len(home)):
            chicken_distance = 1<<31
            for j in range(len(tmp)):
                chicken_distance = min(chicken_distance, abs(home[i][0]-tmp[j][0]) + abs(home[i][1]-tmp[j][1]))
            total += chicken_distance
        ans = min(ans, total)

    for i in range(start, len(ch)):
        if visited[i]: continue
        visited[i] = True
        tmp.append(ch[i])
        recur(cur + 1, i + 1)
        tmp.pop()
        visited[i] = False


N, M = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(N)]
ch = []     #  치킨 위치와 집 위치 나누어 저장
home = []
tmp = []
ans = 1<<31  # 최소값 저장
for i in range(N):
    for j in range(N):
        if city[i][j] == 1: home.append((i, j))
        elif city[i][j] == 2: ch.append((i,j))
distance = [1<<31] * len(ch)
visited = [False] * len(ch)
recur(0, 0)
print(ans)
