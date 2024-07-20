G = int(input())
lst = []
s, e = 1, int(G**0.5)


while G > e:
    if e == s: # 같을때 위로 보냄
        e += 1
        continue
    if e**2 - s**2 == G:
        lst.append(e)
    if e**2 - s**2 > G:
        s += 1
    else:
        e += 1
if len(lst) == 0:
    print(-1)
else:
    for ans in lst:
        print(ans)
