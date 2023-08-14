def dfs(v):
  visited[v] = True
  global res
  for ne in adj_arr[v]:
    if not visited[ne]:
      res += 1
      dfs(ne)

n = int(input())
m = int(input())

adj_arr = [[] for _ in range(n+1)]

for _ in range(m):
  a, b = map(int, input().split())
  adj_arr[a].append(b)
  adj_arr[b].append(a)

res = 0
visited =  [False] * (n+1)
dfs(1)

print(res)