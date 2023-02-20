words = [input() for _ in range(5)]

res = ""
for i in range(max(len(word) for word in words)):
  for j in range(5):
    if i < len(words[j]):
      res += words[j][i]

print(res)