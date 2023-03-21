import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)

def dfs(adj_arr, node):
  isvisited[node] = True
  for ne in adj_arr[node]:
    if not isvisited[ne]:
      dfs(adj_arr, ne)
  
n, m = map(int, input().split())
adj_arr = [[] for _ in range(n+1)]

for _ in range(m):
  a, b = map(int, input().split())
  adj_arr[a].append(b)
  adj_arr[b].append(a)

isvisited = [False] * (n+1)
res = 0

for i in range(1, n+1):
  if not isvisited[i]:
    dfs(adj_arr, i)
    res += 1

print(res)