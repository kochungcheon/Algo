N = int(input())
# 네트워크상 연결되어있는 쌍
m = int(input())
# 컴퓨터 넘버는 1부터 시작 인접 리스트 0 는 패딩
adj = [[] for _ in range(N+1)]
# 인접리스트에 연결쌍을 넣어줌
for _ in range(m):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)
# 1번 컴퓨터가 바이러스가 걸렸다

# 방문 배열 생성
visited = [False] * (N+1)
# visited[1] = True
# q = deque()
# q.append(1)
# while q:
#     x = q.popleft()
#     for y in adj[x]:
#         if visited[y]: continue
#         visited[y] = True
#         q.append(y)
# 1번 컴퓨터를 통해 바이러스 걸리는 컴퓨터 수니 -1
# print(sum(visited)-1)
def DFS(x):
    visited[x] = True
    for y in adj[x]:
        if visited[y]: continue
        DFS(y)
    return sum(visited)

print(DFS(1)-1)