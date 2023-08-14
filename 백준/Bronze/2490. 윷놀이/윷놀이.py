for i in range(3):
  s = sum(list(map(int, input().split())))
  if(s == 0):
    print("D")
  elif(s == 1):
    print("C")
  elif(s == 2):
    print("B")
  elif(s == 3):
    print("A")
  elif(s == 4):
    print("E")