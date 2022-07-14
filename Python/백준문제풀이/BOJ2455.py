res = 0
sum = 0
for _ in range(4):
    m, p = map(int, input().split())
    sum += p
    sum -= m
    res = max(sum, res)
print(res)

