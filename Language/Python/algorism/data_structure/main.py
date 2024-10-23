# # # 리스트 생략

# # # 스택: LIFO 구조
# stack = []

# # 스택에 요소 추가
# stack.append(5)
# stack.append(2)
# stack.append(3)
# print(stack)

# # 스택에서 요소 제거
# print(stack.pop())
# print(stack)


# # # 큐: FIFO 구조
# queue = []

# # 큐에 요소 추가
# queue.append(1)
# queue.append(2)
# queue.append(3)
# print(queue)

# # 큐에서 요소 제거
# print(queue.pop(0))
# print(queue)

# # # 단일 링크드 리스트
# class Node:
#     def __init__(self, data):
#         self.data = data
#         self.next = None
    
# class LinkedList:
#     def __init__(self):
#         self.head = None

#     def append(self, data):
#         new_node = Node(data)
#         if not self.head:
#             self.head = new_node
#             return
#         last_node = self.head
#         while last_node.next:
#             last_node = last_node.next
#         last_node.next = new_node
    
#     def print_list(self):
#         cur_node = self.head
#         while cur_node:
#             print(cur_node.data, end=" -> ")
#             cur_node = cur_node.next
#         print("None")

# # 링크드 리스트 사용
# ll = LinkedList()
# ll.append(1)
# ll.append(2)
# ll.append(3)
# ll.print_list()