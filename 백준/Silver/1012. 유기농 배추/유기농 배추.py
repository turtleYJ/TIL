import sys
sys.setrecursionlimit(100000)  # 재귀 깊이 제한 해제

def dfs(x, y):
  dx = [0, 0, 1, -1]
  dy = [1, -1, 0 ,0]
  
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if nx >= 0 and ny >= 0 and nx < N and ny < M:
      if adj_matrix[nx][ny] == 1:
        adj_matrix[nx][ny] = 0
        dfs(nx, ny)
      
t = int(input())

for _ in range(t):
  M, N, K = map(int, input().split())

  adj_matrix = [[0] * M for _ in range(N)]
  res = 0

  for _ in range(K):
    a, b = map(int, input().split())
    adj_matrix[b][a] = 1

  for i in range(N):
    for j in range(M):
      if adj_matrix[i][j] == 1:
        adj_matrix[i][j] = 0
        dfs(i, j)
        res += 1
  print(res)
