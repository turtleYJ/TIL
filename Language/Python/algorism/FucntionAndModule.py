# import my_module

# print(my_module.greet("yooil"))
# print(my_module.add(1, 2))


# # # 고차 함수
# # 예제 1: 함수의 인자로 다른 함수 받기
# def apply_function(func, value):
#     return func(value)

# def square(x):
#     return x * x

# result = apply_function(square, 10)
# print(result)

# # 예제 2: 함수의 반환값으로 함수를 반환하기
# def create_multiplier(n):
#     def multiplier(x):
#         return x * n
#     return multiplier

# double = create_multiplier(2)
# triple = create_multiplier(3)

# print(double(5)) # 10
# print(triple(5)) # 15

# # # 람다 함수: 한 줄로 작성되는 익명 함수. 간단한 함수 정의 시 유용
# # 람다 함수를 이용한 예제
# add = lambda a, b: a + b
# print(add(1, 2))

# 리스트 정렬 시 사용
# points = [(1, 2), (3, 1), (5, -1), (4, 0)]
# points.sort(key=lambda x: x[1])
# print(points)

# # # 클로저: 함수 내부에 중첩 함수를 정의하고, 이 중첩 함수를 반환하는 함수
# def outer_function(text):
#     def inner_function():
#         print(text)
#     return inner_function

# closure = outer_function("Hello, Closure!")
# closure() # Hello, Closure!
# closure() # Hello, Closure!

# # # 패키지: 모듈을 논리적으로 묶은 것.
# # 패키지 사용 예제
# from mypackage import module1, module2

# print(module1.func1())
# print(module2.func2())
