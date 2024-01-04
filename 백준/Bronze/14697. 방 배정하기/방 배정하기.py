# 방정원 A B C 1=< =< 50
#전체 학생수1=<  N=< 300
#빈침대 없이 출력시 1 불가능 0
# 서브태스크
# 완탐

A, B, C, N = map(int, input().split())
a = 0
b = 0
c = 0 # c 는 N-(a+b)
flag = False
for i in range(301):
    a = A * i
    for j in range(301):
        b = B * j
        for h in range(301):
            c = C * h
            if a + b + c == N:
                flag = True

if flag == True:
    print(1)
else:
    print(0)