n = int(input())

for _ in range(n):
    string = input()
    stack = 0
    for i in range(len(string)):
        if string[i] == '(':
            stack += 1
        else:
            stack -= 1
            if stack < 0:
                print('NO')
                break
    else:
        if stack == 0:
            print('YES')
        else:
            print('NO')