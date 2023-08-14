N, M = map(int, input().split())

arr = []
for i in range(1, N+1):
  arr.append(i)

for _ in range(M):
  n1, n2 = map(int, input().split())
  n1 = n1 -1
  n2 = n2 -1
  temp = arr[n1]
  arr[n1] = arr[n2]
  arr[n2] = temp

print(*arr)