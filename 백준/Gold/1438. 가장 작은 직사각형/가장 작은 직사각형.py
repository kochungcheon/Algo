import sys; input = sys.stdin.readline

def check_dot(x1, x2, y1, y2):
    dot = 0
    for i in range(N):
        if x1 <= lst[i][0] <= x2 and y1 <= lst[i][1] <= y2:
           dot += 1
    if dot >= N//2:
        return True
    return False



N = int(input())
x_lst = []
y_lst = []
lst = []
for _ in range(N):
    x, y = map(int, input().split())
    x_lst.append(x)
    y_lst.append(y)
    lst.append((x, y))
x_lst.sort()
y_lst.sort()
ans = 1<<31
# 완전 탐색으로 x 좌표 잡자
for x1 in range(N):
    for x2 in range(x1, N):
        # 투포인터 y 좌표 잡자
        y1, y2 = 0, 0
        while y1 < N and y2 < N:
            if check_dot(x_lst[x1], x_lst[x2], y_lst[y1], y_lst[y2]):
                area = (abs(x_lst[x2]-x_lst[x1])+2) * (abs(y_lst[y2]-y_lst[y1])+2)
                ans = min(ans, area)
                y1 += 1
            else:
                y2 += 1
print(ans)
