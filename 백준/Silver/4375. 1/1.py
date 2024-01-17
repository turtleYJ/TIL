def check_only_one_digit(num_str):
  for digit in num_str:
    if digit != '1':
      return False
  return True


while True:
  try:
    num = int(input())
  except EOFError:
    break

  current = 1
  while True:
    if current % num != 0:
      current = current * 10 + 1
    else:
      print(len(str(current)))
      break
