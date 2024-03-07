from collections import deque

N, M = map(int, input().split())
mapping = [list(map(int, input().split())) for _ in range(N)]
visit = [[False] * M for _ in range(N)]
di = [(1,0),(-1,0),(0,1),(0,-1)]

def BFS(x, y):
    q = deque()
    q.append((x,y))
    visit[x][y] = True
    while q:
        x, y = q.popleft()
        for dx, dy in di:
            nx, ny = (dx + x)%N, (dy + y)%M
            if visit[nx][ny]: continue
            if mapping[nx][ny]: continue
            visit[nx][ny] = True
            q.append((nx , ny))

cnt = 0
for i in range(N):
    for j in range(M):
        if visit[i][j]: continue
        if mapping[i][j]: continue
        BFS(i, j)
        cnt += 1
print(cnt)