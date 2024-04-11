import sys; input = sys.stdin.readline

def two_pointer():
    global ans
    for i in range(N):
        for j in range(i + 3, N):
            s = i + 1
            e = j - 1
            while s < e:
                tmp = snow[s]+snow[e] - snow[i]-snow[j]
                if tmp == 0:
                    ans = 0
                    return
                ans = min(abs(ans), abs(tmp))
                if tmp > 0:
                    e -= 1
                else:
                    s += 1

N = int(input())
snow = sorted(list(map(int, input().split())))
ans = 1 << 31
two_pointer()

print(ans)
