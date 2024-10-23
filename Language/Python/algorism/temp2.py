from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.right.left = TreeNode(4)
root.right.right = TreeNode(5)

if not root:
    print([])

result = []
queue = deque([root])

while queue:
    level_size = len(queue)
    level_nodes = []

    for _ in range(level_size):
        node = queue.popleft()
        level_nodes.append(node.val)

        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)

    result.append(level_nodes)

print(result)