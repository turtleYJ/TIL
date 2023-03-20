import sys

# Set recursion limit
sys.setrecursionlimit(10000)

def dfs(node, length):
    visited[node] = True
    if length == 4:
        print(1)
        exit()
    for neighbor in adj_list[node]:
        if not visited[neighbor]:
            dfs(neighbor, length+1)
    visited[node] = False

# Read input
n, m = map(int, input().split())
adj_list = [[] for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    adj_list[a].append(b)
    adj_list[b].append(a)

# Perform DFS
visited = [False] * n
for i in range(n):
    dfs(i, 0)

# If no path of length 5 was found, output 0
print(0)