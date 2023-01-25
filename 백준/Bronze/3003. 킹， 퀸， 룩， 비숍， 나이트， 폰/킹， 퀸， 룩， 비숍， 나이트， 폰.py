ref = [1, 1, 2, 2, 2, 8]
li = list(map(int, input().split()))

for i in range(len(ref)):
  print(ref[i] - li[i], end=' ')