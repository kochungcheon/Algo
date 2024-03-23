import sys; input = sys.stdin.readline
n = int(input())
arr = [int(input()) for _ in range(n)]
cnt = 0
if n == 1:
    print(0)
elif arr[0] == max(arr) and arr.count(arr[0]) > 1:
    print(1)
else:
    while arr[0] != max(arr):
        arr[arr.index(max(arr))] -= 1
        arr[0] += 1
        cnt += 1
    if arr.count(arr[0]) > 1:
        print(cnt + 1)
    else:
        print(cnt)
