# # # 연습 문제

# # 고차 함수 사용하기
# def filter_elements(elements, condition):
#     return [element for element in elements if condition(element)]

# def is_even(n):
#     return n % 2 == 0

# elements = [1,2,3,4,5,6,7,8,9,10]
# filtered = filter_elements(elements, is_even)
# print(filtered)

# # 람다 함수 사용하기
# numbers = [1,2,3,4,5,6,7,8,9,10]
# square = lambda x: x * x
# squared = list(map(square, numbers))
# print(squared)

# # 클로저 사용하기 : 카운터 기능을 하는 크ㅡㄹ로저 사용하기
# def make_counter():
#     count = 0
#     def add():
#         nonlocal count
#         count += 1
#         return count
#     return add

# counter = make_counter()
# print(counter())
# print(counter())
# print(counter())

# # # 패키지 생략