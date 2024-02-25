n = int(input())
A = list(map(int, input().split()))

res = max(A) * min(A)
print(res)