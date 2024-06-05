# # # 1. 문자열
# # 문자열 연결 및 반복
# hello = "Hello"
# world = "World"
# greeting = hello + " " + world
# repeat_hello = hello * 3

# print(greeting)
# print(repeat_hello)

# # 문자열 슬라이싱
# s = "Python"
# print(s[0:2])
# print(s[2:])
# print(s[-1])

# # 문자열 메서드
# s = "hello world"
# print(s.upper())
# print(s.capitalize())
# print(s.replace("world", "Python"))

# # # 2. 리스트 다루기
# # 리스트 연결 및 반복
# my_list = [1,2,3,4,5]
# my_list.append(6)
# print(my_list)
# my_list.remove(3)
# print(my_list)
# my_list.insert(2, 10)
# print(my_list)

# # 리스트 컨프리헨컨
# squares = [x**2 for x in range(10)]
# print(squares)

# # # 3. 튜플
# # 튜플은 변경 불가능한 자료형
# my_tuple = (1,2,3,4,5)
# print(my_tuple[1])
# print(my_tuple[-1])
# 튜플은 변경 불가능하기 때문에 에러가 발경
# my_tuple[1] = 10

# # # 4. 집합
# # 집합은 중복을 허용하지 않고 순서가 없다.
# set1 = {1,2,3,4,5}
# set2 = {4,5,6,7,8}

# print(set1 & set2) # 교집합 set1.intersection(set2)
# print(set1 | set2) # 합집합 set1.union(set2)
# print(set1 - set2) # 차집합 set1.difference(set2)

# # # 문제
# # 사용자로부터 이름과 나이를 입력받아 출력하는 프로그램을 작성해보세요.
# with open("input_data.txt", 'r') as f:
#     name = f.readline().strip()
#     age = f.readline().strip()

# print("안녕하세요,", name, "님! 당신은", age, "살 이군요!")
# print("안녕하세요, {}님! 당신은 {}살 이군요!".format(name, age))

# # 주어진 리스트 '[1,2,3,4,5]'에서 각 요소를 제곱한 새로운 리스트를 생성하는 프로그램을 작성해보세요.
# squares = [x**2 for x in [1,2,3,4,5]]
# print(squares)

# 학생들의 이름과 점수를 담은 딕셔너리 {"John": 90, "Alice": 85, "Bob": 75} 가 주어졌을 때, 가장 높은 점수를 받은 학생의 이름을 출력하는 프로그램을 작성해보세요.
scores = {"John": 90, "Alice": 85, "Bob": 75}
highest_score = max(scores.values())
print(highest_score)
highest_score_student = [name for name, score in scores.items() if score == highest_score]
print(highest_score_student[0])
