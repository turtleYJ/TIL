burgerMin = 2000
drinkMin = 2000

for i in range(3):
    p = int(input())
    burgerMin = min(burgerMin, p)

for i in range(2):
    p = int(input())
    drinkMin = min(drinkMin, p)

print(burgerMin + drinkMin - 50)
