import sys; input = sys.stdin.readline
T = int(input())

for _ in range(T):
    division, N = map(int, input().split())
    arr = [0] + list(map(int, input().split()))
    len_arr = len(arr)
    prefix = [0 for _ in range(N+1)]
    nameoji = {}
    ans = 0
    for i in range(1, len_arr):
        prefix[i] = prefix[i-1] + arr[i]
        idx = prefix[i]%division
        nameoji[idx] = nameoji.get(idx, 0) + 1

    for key in nameoji.keys():
        ans += nameoji[key]*(nameoji[key]-1)//2

    ans += nameoji.get(0, 0)
    print(ans)
