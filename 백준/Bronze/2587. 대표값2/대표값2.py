li = []

for _ in range(5):
  num = int(input())
  li.append(num)

li.sort()
avg = sum(li) / len(li)

print(round(avg))
print(li[2])