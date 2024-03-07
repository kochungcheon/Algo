def main():
    n = int(input())
    dp = [i for i in range(n+1)]
    for i in range(n+1):
        for j in range(i):
            if j*j > i: break
            dp[i] = min(dp[i], dp[i-j*j] + 1)
    print(dp[n])
if __name__ == "__main__":
    main()