def dfs(graph, start, visited, cnt):
  visited[start] = True
  if cnt == 4:
    print('1')
    exit() 
  for ne in graph[start]:
    if not visited[ne]:
      dfs(graph, ne, visited, cnt+1)
  visited[start] = False    
  
n, m = map(int, input().split())

# 인접 리스트 그래프 구현
adj_list = [[] for _ in range(n)]
for _ in range(m):
  a, b = map(int, input().split())
  adj_list[a].append(b)
  adj_list[b].append(a)

visited = [False] * (n)

for i in range(n):
  if not visited[i]:
    dfs(adj_list, i, visited, cnt = 0)

print('0')
