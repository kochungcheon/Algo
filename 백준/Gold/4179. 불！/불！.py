import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()


'''
상근이는 벽을 통과할 수 없고, 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동할 수 없다.
상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다.
빌딩을 탈출할 수 없는 경우에는 "IMPOSSIBLE"을 출력한다.
'.': 빈 공간
'#': 벽
'@': 상근이의 시작 위치
'*': 불
위치 상근/불 시간
w - 1 , h - 1 에 도달하면 탈출 못하면 ㅠㅠ
해당 값을 저장 하는 변수 만들자 for 문 돌리면서 헛짓 하지 말고
'''



# 가로 세로
r, c = map(int, input().split())
# 빌딩
mapping = [list(map(str, input())) for _ in range(r)]
# 방문 배열
visited = [[1e9] * c for _ in range(r)]
# 네 방향 탐색
di = [(1, 0), (-1, 0), (0, 1), (0, -1)]
fire = deque()
q = deque()
# 불과 상근이 정보 넣기 넣을 필요가 있을 까 그저 디버깅용? 리소스 낭비 같은 데
for i in range(r):
    for j in range(c):
        if mapping[i][j] == 'J':
            # 좌표, 상근이, 시간   시간에 1을 넣은 이유는 상근이가 처음부터 탈출 직전일 경우 있어서
            q.append((i, j, mapping[i][j], 1))
            visited[i][j] = 1
        elif mapping[i][j] == 'F':
            fire.append((i, j, mapping[i][j], 1))
            visited[i][j] = 1
# 탈출했으면 시간 탈출 못했으면 0

while fire:
    x, y, u, time = fire.popleft()
    for dx, dy in di:
        nx, ny = dx + x, dy + y
        # 벽 체크
        if nx < 0 or ny < 0 or nx >= r or ny >= c: continue
        # 시간 체크
        if time + 1 >= visited[nx][ny]: continue
        # 찐 벽 체크
        if mapping[nx][ny] == '#': continue

        # 방문 체크
        visited[nx][ny] = time + 1
        mapping[nx][ny] = 'F'
        fire.append((nx, ny, u, time + 1))
# print(mapping)
# print(visited)
escape = 0
# 동근이 탈출 가즈아
while q:
    x, y, u, time = q.popleft()
    ### 빠져나왔는 지 판단 하기 escape변수에다 저장
    if x == r - 1 or y == c - 1 or x == 0 or y == 0:
        escape = time
        break
    for dx, dy in di:
        nx, ny = dx + x, dy + y
        # 벽 체크
        if nx < 0 or ny < 0 or nx >= r or ny >= c: continue
        # 시간 체크
        if time + 1 >= visited[nx][ny]: continue
        if mapping[nx][ny] == '#': continue

        visited[nx][ny] = time + 1
        mapping[nx][ny] = 'J'
        q.append((nx, ny, 'J', time + 1))

# 불 지르고
# 빠져나가면 편할 거 같은 데
# print(mapping)
# print(visited)
print(escape if escape else 'IMPOSSIBLE')
