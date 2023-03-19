def dfs():
  if len(s) == M:
    print(' '.join(map(str, s)))
    return
  for i in range(1, N+1):
    if not visited[i]:
      s.append(i)
      visited[i] = True
      dfs()
      s.pop()
      visited[i] = False

N, M = map(int, input().split())
s = []
visited = [False] * (N+1)

dfs()
  