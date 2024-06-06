# # Stack구현
# class Stack:
#     def __init__(self):
#         self.stack = []

#     def push(self, data):
#         self.stack.append(data)

#     def pop(self):
#         if self.is_empty():
#             return None
#         return self.stack.pop()

#     def peek(self):
#         if self.is_empty():
#             return None
#         return self.stack[-1]
    
#     def is_empty(self):
#         return len(self.stack) == 0
    
# s = Stack()
# s.push(1)
# s.push(2)
# s.push(3)
# print(s.pop())
# print(s.peek())

## Queue 구현
# class Queue:
#     def __init__(self):
#         self.queue = []

#     def enqueue(self, data):
#         self.queue.append(data)

#     def dequeue(self):
#         if self.is_empty():
#             return None
#         return self.queue.pop(0)
    
#     def peek(self):
#         if self.is_empty():
#             return None
#         return self.queue[0]
    
#     def is_empty(self):
#         return len(self.queue) == 0
    
# # 큐 사용 예제
# q = Queue()
# q.enqueue(1)
# q.enqueue(2)
# q.enqueue(3)
# print(q.dequeue()) # 1
# print(q.peek()) # 2

# # 링크드 리스트
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        last_node = self.head
        while last_node.next:
            last_node = last_node.next
        last_node.next = new_node

    def delete_node(self, key):
        cur_node = self.head

        if cur_node and cur_node.data == key:
            self.head = cur_node.next
            cur_node = None
            return
        
        prev = None
        while cur_node and cur_node.data != key:
            prev = cur_node
            cur_node = cur_node.next

        if cur_node is None:
            return
        
        prev.next = cur_node.next
        cur_node = None

    def print_list(self):
        cur_node = self.head
        while cur_node:
            print(cur_node.data, end=" -> ")
            cur_node = cur_node.next
        print("None")

# 링크드 리스트 사용
ll = LinkedList()
ll.append(1)
ll.append(2)
ll.append(3)
ll.print_list()
ll.delete_node(2)
ll.print_list()
        