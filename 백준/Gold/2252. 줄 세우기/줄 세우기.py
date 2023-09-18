import sys ; input = lambda : sys.stdin.readline().rstrip()
from collections import deque

N , M = map(int, input().split())
graph = [[] for _ in range(N+1)]
indegree = [0] * (N+1)
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    indegree[B] += 1

result = []
q = deque()
for i in range(1, N+1):
    if not indegree[i]:
        q.append(i)
while q:
    now = q.popleft()
    result.append(now)
    for j in graph[now]:
        indegree[j] -= 1
        if not indegree[j]:
            q.append(j)
print(*result)