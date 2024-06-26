import sys
input = sys.stdin.readline
from collections import deque

def BFS(x):
    visited = [0] * N
    queue = deque()
    queue.append(x)
    while queue:
        x = queue.popleft()
        for y in range(N):
            if not adj[x][y] or visited[y]: continue
            visited[y] = 1
            queue.append(y)
    for i in range(N):
        print(visited[i], end=" ")
    print()


N = int(input())
adj = [list(map(int, input().split())) for _ in range(N)]
for i in range(N):
    BFS(i)






