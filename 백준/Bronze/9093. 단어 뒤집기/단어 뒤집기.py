N=int(input())

for i in range(N) :
  str=input()
  str += " "
  stack = []
  for j in str :
    if j != " " :
      stack.append(j)
    else :
      while stack:
        print(stack.pop(), end='')
      print(' ', end='')