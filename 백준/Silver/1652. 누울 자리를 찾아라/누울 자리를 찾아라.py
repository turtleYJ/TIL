import sys
input = sys.stdin.readline

N = int(input())
arr = []

for i in range(N):
  s = list(input().rstrip())
  arr.append(s)

X = 0
Y = 0
for i in range(N):
  cntX = 0
  cntY = 0
  flagX = False
  flagY = False

  for j in range(N):
    if arr[i][j] == '.':
      cntX += 1
    else:
      cntX = 0
    
    if cntX == 2:
      X += 1

    if arr[j][i] == '.':
      cntY += 1
    else:
      cntY = 0
    if cntY == 2:
      Y += 1

print(X, Y)