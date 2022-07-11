# 리스트 [] 

# # 지하철 칸별로 10명, 20명, 30명
# subway = [10, 20, 30]
# print(subway)

# subway = ["유재석", "조세호", "박명수"]

# # 조세호씨가 몇 번째 칸에 타고 있는가?
# print(subway.index("조세호"))

# # 하하가 다음 정류장에서 다음 칸에 탐
# subway.append("하하")
# print(subway)

# # 정형돈씨를 유재석 / 조세호 사이에 태워봄
# subway.insert(1, "정형돈")
# print(subway)

# 지하철에 있는 사람을 한 명씩 뒤에서 꺼냄
# print(subway.pop())
# print(subway)
# print(subway.pop())
# print(subway)
# print(subway.pop())
# print(subway)

# 같은 이름의 사람이 몇 명 있는지 확인
# subway.append("유재석")
# print(subway)
# print(subway.count("유재석"))

# # 정렬도 가능
# num_list = [5,2,4,3,1]
# num_list.sort()
# print(num_list)

# # 내림차순 정렬
# num_list.reverse()
# print(num_list)

# # 모두 지우기
# num_list.clear()
# print(num_list)

# # 다양한 자료형 함께 사용
# num_list = [5,2,4,3,1]
# mix_list = ["조세호", 20, True]
# print(mix_list)

# # 리스트 확장
# num_list.extend(mix_list)
# print(num_list)

# Dictionary
# cabinet = {3 : "유재석", 100 : "김태호"}
# print(cabinet[3])
# print(cabinet[100])

# print(cabinet.get(3))

# get을 이용하면 None이 나오고, []를 이용하면 프로그램 종료
# print(cabinet[5])
# print(cabinet.get(5))
# print(cabinet.get(5, "사용 가능"))
# print("hi")

# print(3 in cabinet) # True
# print(5 in cabinet) # False

# cabinet = {"A-3" : "유재석", "B-100" : "김태호"}
# print(cabinet["A-3"])
# print(cabinet["B-100"])

# # 새 손님
# print(cabinet)
# cabinet["A-3"] = "김종국"
# cabinet["C-20"] = "조세호"
# print(cabinet)

# # 간 손님
# del cabinet["A-3"]
# print(cabinet)

# # key 들만 출력
# print(cabinet.keys())

# # value 들만 출력
# print(cabinet.values())

# # key, value 쌍으로 출력
# print(cabinet.items())

# # 목욕탕 폐점
# cabinet.clear()
# print(cabinet)


# 튜플(tuple) - 리스트처럼 변경할 수 없지만 리스트보다 빠르다.
# menu = ("돈까스", "치즈까스")
# print(menu[0])
# print(menu[1])

# menu.add("생선까스")

# name = "김종국"
# age = 20
# hobby = "코딩"
# print(name, age, hobby)

# name, age, hobby = "김종국", 20, "코딩"
# (name, age, hobby) = ("김종국", 20, "코딩")
# print(name, age, hobby)


# 집합(set)
# 중복이 안됨, 순서가 없음
# my_set = {1,2,3,3,3}
# print(my_set)

# java = {"유재석", "김태호", "양세형"}
# python = set(["유재석", "박명수"])

# # 교집합 (java 와 python을 모두 할 수 있는 사람)
# print(java & python)
# print(java.intersection(python))

# # 합집합
# print("합집합")
# print(java | python)
# print(java.union(python))

# # 차집합(자바는 할 수 있지만 파이선은 할 줄 모르는 개발자)
# print(java - python)
# print(java.difference(python))

# # python을 할 줄 아는 사람이 늘어남.
# python.add("김태호")
# print(python)

# # java를 까먹음
# java.remove("김태호")
# print(java)

# 자료구조의 변경
# menu = {"커피", "우유", "주스"}
# print(menu, type(menu))

# menu = list(menu)
# print(menu, type(menu))

# menu = tuple(menu)
# print(menu, type(menu))

# menu = set(menu)
# print(menu, type(menu))

# # Quiz)
# list = list()
# for i in range(1, 21):
#     list.append(i)

# from random import *
# shuffle(list)
# print(list.pop())
# print(sample(list, 3))
# print(list)

# 분기문
# weather = input("오늘 날씨는 어떄요? ")
# if weather == "비" or weather =="눈":
#     print("우산을 챙기세요")
# elif weather == "미세먼지":
#     print("마스크를 챙기세요")
# else:
#     print("준비물이 필요 없어요")

# temp = int(input("기온이 어떄요? "))
# if 30 <= temp:
#     print("너무 더워요. 나가지 마세요")
# elif 10 <= temp and temp < 30:
#     print("괜찮은 날씨에요")
# elif 0 <= temp < 10:
#     print("외투를 챙기세요")
# else:
#     print("너무 추워요. 나가지 마세요")


# for
# print("대기번호 : 1")
# print("대기번호 : 2")
# print("대기번호 : 3")
# print("대기번호 : 4")

# for waiting_no in [0, 1, 2, 3, 4]:
#     print("대기번호 : {0}".format(waiting_no))
# for waiting_no in range(5):
#     print("대기번호 : {0}".format(waiting_no))
# for waiting_no in range(1, 6):
#     print("대기번호 : {0}".format(waiting_no))

# starbucks = ["아이언맨", "토르", "아이엠 그루트"]
# for customer in starbucks:
#     print("{0}, 커피가 준비되었습니다.".format(customer))


# while
# customer = "토르"
# index = 5
# while index >= 1:
#     print("{0}, 커피가 준비 되었습니다. {1} 번 남았어요.".format(customer, index))
#     index -= 1
#     if index == 0:
#         print("커피는 폐기처분되었습니다.")

# customer = "아이언맨"
# index = 1
# while True:
#     print("{0}, 커피가 준비 되었습니다. {1} 회".format(customer, index))
#     index += 1

# customer = "토르"
# person = "Unknown"

# while person != customer :
#     print("{0}, 커피가 준비 되었습니다.".format(customer))
#     person = input("이름이 어떻게 되세요? ")


# continue, break
# absent = [2, 5] # 결석
# no_book = [7]
# for student in range(1, 11): # 1 ~ 10
#     if student in absent:
#         continue
#     if student in no_book:
#         print("오늘 수업 여기까지. {0}는 교무실로 따라와".format(student))
#         break
#     print("{0}, 책을 읽어봐".format(student))

# 출석번호가 1 2 3 4, 앞에 100을 붙이기로 함 -> 101, 102, 103, 104.
# students = [1,2,3,4,5]
# print(students)
# students = [i + 100 for i in students]
# print(students)

# 학생 이름을 길이로 변환
# students = ["Iron man", "Thor", "I am groot"]
# students = [len(i) for i in students]
# print(students)

# 학생 이름을 대문자로 변환
# students = ["Iron man", "Thor", "I am groot"]
# students = [i.upper() for i in students]
# print(students)

# Quiz)
from random import *
res = 0
for i in range(1, 51):
    time = randrange(5, 51)
    if 5 <= time <= 15 :
        print("[O] {0}번째 손님 (소요시간 : {1}분)".format(i, time))
        res += 1
    else:
        print("[ ] {0}번째 손님 (소요시간 : {1}분)".format(i, time))
        
print("총 탑승 승객 : {0}".format(res))















