arr = sorted([int(input()) for _ in range(9)])

# 난쟁이 아닌 것들의 인덱스
first: int = 0
secend: int = 0


for i in range(len(arr)-1):
    for j in range(i+1, len(arr)):
        if sum(arr) - arr[i] - arr[j] == 100:
            first, secend = i, j

for h in range(9):
    if h != first and h != secend:
        print(arr[h])
