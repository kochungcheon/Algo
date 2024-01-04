def check(num):
    lst = [0] * 10;
    while num:
        temp = num % 10
        lst[temp] += 1
        if lst[temp] >= 2:
            return False
        num //= 10
    return True

nums = [0]
i = 1
idx = 1

while idx <= 1000000:
    if check(i):
        nums.append(i)
        idx += 1
    i += 1

while True:
    N = int(input())
    if N == 0:
        break
    print(nums[N])
