'''
적어도 M 미터의 나무를 집에 가져가기 위해 설정할 수 있는 높이의 최대 값
모든 높이를 본다 -> 필요 없는 높이 제거
높이를 일부만 보겠다.
완탐부터 적용 한 후 테크닉 적용

'''

import sys
input = sys.stdin.readline
def check(x):
    total = 0
    for i in arr:
        if i > x:
            total += i - x
    return total >= M

N, M = map(int, input().rstrip().split())
arr = list(map(int, input().split()))

s, e = 0, 1000000000
ans = 0
while s <= e:
    mid = (s + e) // 2
    if check(mid): # mid 에서 충분한 높이를 얻을 수 있다면
        ans = mid
        s = mid + 1
    else:
        e = mid - 1
print(ans)