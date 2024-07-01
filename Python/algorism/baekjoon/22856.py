# import sys

# class Node:
#     def __init__(self, key):
#         self.left = None
#         self.right = None
#         self.val = key

# def in_order_traversal(node, end):
#     # if node == None:
#         # return

#     print(node.key)

#     if node.key != end:
#         return
#     if node.left != -1:
#         in_order_traversal(node.left, end)
#     if node.right != -1:
#         in_order_traversal(node.right, end)





# input = lambda: sys.stdin.readline().rstrip()
# N = int(input())


class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.nodes = {}
        self.root = None
        self.move_count = 0
        self.end = None
        self.is_end_pass = False

    def insert(self, parent, left, right):
        if parent not in self.nodes:
            self.nodes[parent] = Node(parent)
        node = self.nodes[parent]

        if left != -1:
            if left not in self.nodes:
                self.nodes[left] = Node(left)
            node.left = self.nodes[left]

        if right != -1:
            if right not in self.nodes:
                self.nodes[right] = Node(right)
            node.right = self.nodes[right]

        if self.root is None:
            self.root = node

    def define_end(self, end_key):
        self.end = end_key

    def in_order_traversal(self, node):
        if node.key == self.end:
            self.is_end_pass = True

        if node.left:
            self.move_count += 1
            self.in_order_traversal(node.left)
            self.move_count += 1
        
        # 현재 노드 방문 (여기서 이동은 없지만 방문으로 인식)

        if node.right:
            self.move_count += 1
            self.in_order_traversal(node.right)
            if self.is_end_pass:
                return
            self.move_count += 1

def main():
    import sys
    input = lambda: sys.stdin.readline().rstrip()
    N = int(input())
    tree = BinaryTree()

    for i in range(N):
        # parent = int(data[index])
        # left = int(data[index + 1])
        # right = int(data[index + 2])
        parent, left, right = map(int, input().split())
        tree.insert(parent, left, right)
        if i == N-1:
            tree.define_end(parent)
    
    # 중위 순회 시작
    tree.in_order_traversal(tree.root)
    
    # 루트로 다시 돌아오는 이동 횟수는 포함하지 않으므로 1을 뺍니다.
    print(tree.move_count)

if __name__ == "__main__":
    main()