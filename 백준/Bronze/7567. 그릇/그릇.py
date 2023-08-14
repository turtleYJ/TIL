str = input()
stack = []
cnt = 0

for c in str:
  if stack and c == stack[-1]:
    cnt += 5
  else:
    cnt += 10
  stack.append(c)
print(cnt)