from collections import deque

def dfs(ajd_list, start, visited):
  visited[start] = True
  print(start, end = ' ')
  for ne in ajd_list[start]:
    if not visited[ne]:
      dfs(ajd_list, ne, visited)
def bfs(ajd_list, start, visited):
  d = deque([start])
  visited[start] = True
  while d:
    v = d.popleft()
    print(v, end = ' ')
    for ne in ajd_list[v]:
      if not visited[ne]:
        visited[ne] = True
        d.append(ne)
        
n, m, v = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
  x, y = map(int, input().split())
  graph[x].append(y)
  graph[y].append(x)

for g in graph:
  g.sort()

visited = [False] * (n+1)
dfs(graph, v, visited)
print()
visited = [False] * (n+1)
bfs(graph, v, visited)