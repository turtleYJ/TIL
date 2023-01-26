while 1 :
  str = input()
  if str == '#' :
    break
  cnt = 0
  for c in str :
    if c in 'aeiouAEIOU':
      cnt += 1
  print(cnt)