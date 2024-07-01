# # 방 배정하기
# def can_allocated_rooms(A,B,C,N):
#     for i in range (N // A + 1):
#         for j in range ((N - i * A) // B + 1):
#             if (N - i*A - j*B) % C == 0:
#                 return 1
#     return 0

# A,B,C,N = map(int, input().split())
# print(can_allocated_rooms(A,B,C,N))

# # 단어의 개수 세기
# print(len(input().split()))

# # 프랑스어일 경우
# import re

# 축약형 처리를 위한 접두사 목록
# contractions = ["c'", "j'", "n'", "m'", "t'", "s'", "l'", "d'", "qu'"]

# def split_french_words(text):
#     # 1. 띄어쓰기와 하이픈을 기준으로 분리
#     words = re.split(r'[ \t\n\r\f\v-]+', text)
    
#     expanded_words = []
    
#     # 2. 축약형 처리
#     for word in words:
#         matched = False
#         for contraction in contractions:
#             # 축약형을 인식하여 분리
#             pattern = re.compile(r"^" + contraction + r"([aeiouh].*)$")
#             match = pattern.match(word)
#             if match:
#                 expanded_words.append(contraction)
#                 expanded_words.append(match.group(1))
#                 matched = True
#                 break
#         if not matched:
#             expanded_words.append(word)

#     # 공백 제거
#     expanded_words = [word for word in expanded_words if word]

#     return expanded_words

# def count_french_words(text):
#     words = split_french_words(text)
#     return len(words)

# s = input()
# print(count_french_words(s))

# # 막대기 (보이는 막대의 개수)
# import sys 

# def count_visible_rods(heights):
#     key = 0
#     count = 0
#     for height in reversed(heights):
#         if (height > key):
#             count += 1
#             key = height
#     return count

# input_data = sys.stdin.read().strip()
# data = input_data.splitlines()
# N = int(data[0])
# heights = list(map(int, data[1:]))

# print(count_visible_rods(heights))

# # 직각다각형
# import sys

# def count_max_crossing(n, coords):
#     MAX = 500000*2

#     count_x = [0] * (MAX + 1)
#     count_y = [0] * (MAX + 1)

#     for i in range(n):
#         x, y = coords[i]
#         nx, ny = coords[(i + 1) % n]

#         if x == nx:
#             if y < ny:
#                 count_y[y] += 1
#                 count_y[ny] -= 1
#             else:
#                 count_y[ny] += 1
#                 count_y[y] -= 1
#         if y == ny:
#             if x < nx:
#                 count_x[x] += 1
#                 count_x[nx] -= 1
#             else:
#                 count_x[nx] += 1
#                 count_x[x] -= 1

#     for i in range(1, MAX + 1):
#         count_x[i] += count_x[i - 1]
#         count_y[i] += count_y[i - 1]

#     return max(max(count_x), max(count_y))

# lines = sys.stdin.readlines()
# n = int(lines[0])
# coords = [list(map(int, line.strip().split())) for line in lines[1:]]
# coords = [(x + 500000, y + 500000) for x, y in coords]
# print(count_max_crossing(n, coords))

# # 쇼핑몰
# import sys
# sys.setrecursionlimit(10**9)
# pre_order = []
# while True:                            
#     try:
#         pre_order.append(int(sys.stdin.readline()))
#     except:
#         break
        
# # s가 루트
# def postorder(start, end):
#     if start > end:
#         return
#     mid = end + 1                         # 오른쪽 노드가 없을 경우

#     for i in range(start+1, end+1):
#         if pre_order[start] < pre_order[i]:
#             mid = i
#             break

#     postorder(start+1, mid-1)               # 왼쪽 확인
#     postorder(mid, end)                   # 오른쪽 확인
#     print(pre_order[start])

# postorder(0, len(pre_order)-1)

import sys

def postorder(start, end, pre_order):
    if start > end:
        return
    
    mid = end + 1
    
    for i in range(start+1, end+1):
        if pre_order[start] < pre_order[i]:
            mid = i
            break
    postorder(start+1, mid-1, pre_order)
    postorder(mid, end, pre_order)
    print(pre_order[start])
    

pre_order = []
while True:
    try:
        pre_order.append(int(sys.stdin.readline()))
    except:
        break
        
postorder(0, len(pre_order) - 1, pre_order)








# import sys
# import heapq
# import io 

# class CashierQueue:
#     def __init__(self, max_size):
#         self.heap = [0] * max_size
#         self.index = 1
#         self.max_size = max_size

#     def push(self, priority, index, item):
#         # 우선순위 큐에 요소를 추가한다.
#         # (priority, item) 튜플을 힙에 추가하여 우선순위를 기준으로 정렬되게 한다.
#         if index == -9:
#             heapq.heappush(self.heap, (priority, -self.index, item))
#             self.index += 1
#             print("push: ", sorted(self.heap, key=lambda x: x[1], reverse=True))
#         else:
#             heapq.heappush(self.heap, (priority, index, item))
#             print("push: ", sorted(self.heap, key=lambda x: x[1], reverse=True))

#     def pop(self):
#         # 우선순위 큐에서 가장 높은 우선순위를 가진 요소를 제거하고 반환합니다.
#         res = heapq.heappop(self.heap)
#         print("pop: ", res)
#         return res

#     def is_empty(self):
#         return len(self.heap) == 0

#     def is_full(self):
#         return len(self.heap) >= self.max_size
#     def has_same_priority(self, priority):
#         if len(self.heap) < 2:
#             return False
#         for element in self.heap:
#             if element[0] == priority:
#                 return True

# def pop_from_cashier(cashier):



# # 입력 데이터
# example_input = """10 3
# 123 4
# 21 5
# 34 14
# 56 1
# 45 7
# 723 5
# 55 7
# 13 5
# 910 10
# 73 3
# """
# sys.stdin = io.StringIO(example_input)
# lines = sys.stdin.readlines()
# N, K = map(int, lines[0].split())
# cashier = CashierQueue(K)
# res = 0
# i = 1
# offset = 0

# for line in range(K):
#     id, priority = map(int, line.split())
#     cashier.push(priority, -9, id) 


# for line in lines[K:]:
#     if cashier.is_full:
#         pop_from_cashier(cashier)
#     else:




#     if not cashier.is_full():
#         id, priority = map(int, line.split())
#         cashier.push(priority, -9, id)
#     else:
#         index_list  = [] # stack
#         pop_id_list = [] # queue
#         pop_priority, index, pop_id = cashier.pop()
#         index_list.append(index)
#         pop_id_list.append(pop_id)

#         while cashier.has_same_priority(pop_priority):
#             _, index, pop_id = cashier.pop()
#             index_list.append(index)
#             pop_id_list.append(pop_id)

#         if offset == 0:
#             offset = pop_priority
#         for _ in range(len(pop_id_list)):
#             pop_id = pop_id_list.pop()
#             index = index_list.pop(0)
#             cashier.push(offset + priority, index, id)
#             res += i * pop_id
#             print(f'{i} * {pop_id}', "\n")
#             i += 1

#         offset += 1

# while not cashier.is_empty():
#     _, index, pop_id = cashier.pop()
#     print(f'{i} * {pop_id}')
#     res += i * pop_id
#     i += 1

# print(res)