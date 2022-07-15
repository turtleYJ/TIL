# a, b = map(int, input().split())
# min = min(a, b)

# divisor = 0
# for i in range(min, 0, -1):
#     if a % i == 0 and b % i == 0:
#         divisor = i
#         break

# multiple = 0
# i = 1
# while True:
#     target = min * i
#     if target % a == 0 and target % b == 0:
#         multiple = target
#         break
#     i += 1

# print(divisor)
# print(multiple)

import math

a, b = map(int, input().split())

print(math.gcd(a, b))
print(math.lcm(a, b))