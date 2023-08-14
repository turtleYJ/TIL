str = input()
res = ""

for c in str:
  nextC = ord(c) - 3
  if nextC < 65:
    nextC += 26
  res += chr(nextC)
print(res)