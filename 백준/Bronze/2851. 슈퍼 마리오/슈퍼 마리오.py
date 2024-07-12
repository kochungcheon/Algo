score_list = []
score = 0

for _ in range(10):
    score_list.append(int(input()))

for i in range(10):
    score += score_list[i]
    if score > 100:
        if abs(sum(score_list[:i])-100) < abs(sum(score_list[:i+1])-100):
            print(sum(score_list[:i]))
            break
        else:
            print(sum(score_list[:i+1]))
            break
else:
    print(sum(score_list))
