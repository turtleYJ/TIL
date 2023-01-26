str = input()
cnt = 0

for s in str:
  if s in 'aeiou':
    cnt += 1

print(cnt)