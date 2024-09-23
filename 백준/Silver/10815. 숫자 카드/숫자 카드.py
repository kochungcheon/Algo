n = int(input())
arr = sorted(list(map(int, input().split())))
m = int(input())
quary = list(map(int, input().split()))




for q in quary:
    ans = 0
    s = 0
    e = n - 1

    while s <= e:
        mid = (s + e) // 2
        if arr[mid] == q:
            ans = 1
            break
        elif arr[mid] < q:
            s = mid + 1
        else:
            e = mid - 1

    print(ans, end= ' ')