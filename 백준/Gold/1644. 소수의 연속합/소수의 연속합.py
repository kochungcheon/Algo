N =int(input())
prime_arr = []
prime = [True for i in range(N+1)] #다 소수로 생각하고 시작

prime[1] = False #그러나 1의 처리
for i in range(2, N+1): #2부터 백만까지 만약에 not prime이면 무시
    if not prime[i]:  #이번 i 가 소수가 아니면 넘어가고
        continue

    for j in range(i*i, N+1, i):  #이미 지워진것 넘기고 지우겠다.
        prime[j] =False

for i in range(N+1):
    if prime[i]:
        prime_arr.append(i)

sum_prime = 0 # 연속된 소수들의 합
cnt = 0 # 합이 N이 되는 연속된 소수 개수 체크
s = 0
e = 0

while True:
    if sum_prime == N:
        cnt += 1
    if sum_prime > N:
        sum_prime -= prime_arr[s]
        s += 1
    elif e == len(prime_arr):
        break
    elif sum_prime <= N:
        sum_prime += prime_arr[e]
        e += 1

print(cnt)