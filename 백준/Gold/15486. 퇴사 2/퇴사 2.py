import sys 
input = sys.stdin.readline
sys.setrecursionlimit(10000000) 

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [None for i in range(1500010)]

def recur(cur):
    global ans
    if cur > n:
        return -10000000000
    if cur == n:
        return 0
    if dp[cur] != None:
        return dp[cur]
    dp[cur] = max(recur(cur + 1), recur(cur+arr[cur][0]) + arr[cur][1])
    return dp[cur]


print(recur(0))