num = 1
cnt = 0
arr = [0]
for i in range(1000):
  arr.append(num)
  cnt += 1
  if  cnt == num:
    cnt = 0
    num += 1
  
A, B = map(int, input().split())

print(sum(arr[A:B+1]))