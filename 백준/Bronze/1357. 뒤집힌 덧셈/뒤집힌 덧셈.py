X, Y = map(str, input().split())

res = int(str(int(X[::-1]) + int(Y[::-1]))[::-1])
print(res)