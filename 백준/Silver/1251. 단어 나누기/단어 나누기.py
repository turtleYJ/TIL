arr = list(input())
words = []

for i in range(1, len(arr)-1):
  for j in range(i+1, len(arr)):
    w1 = ''.join(arr[:i])
    w2 = ''.join(arr[i:j])
    w3 = ''.join(arr[j:])
    word = w1[::-1] + w2[::-1] + w3[::-1]
    words.append(word)

words.sort()
print(words[0])