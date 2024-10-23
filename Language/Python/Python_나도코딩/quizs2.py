

# # Quiz)
# list = list()
# for i in range(1, 21):
#     list.append(i)

# from random import *
# shuffle(list)
# print(list.pop())
# print(sample(list, 3))
# print(list)

# Quiz)
# from random import *
# res = 0
# for i in range(1, 51):
#     time = randrange(5, 51)
#     if 5 <= time <= 15 :
#         print("[O] {0}번째 손님 (소요시간 : {1}분)".format(i, time))
#         res += 1
#     else:
#         print("[ ] {0}번째 손님 (소요시간 : {1}분)".format(i, time))
        
# print("총 탑승 승객 : {0}".format(res))


# Quiz) 표준 체중을 구하는 프로그램
# 남자 : 키 * 키 * 22
# 여자 : 키 * 키 * 21


# height = int(input("키를 입력해 주세요 : "))
# gender = input("성별을 입력해 주세요 : ")

# def std_weight(height, gender):
#     if gender == "남자":
#         return (height / 100) * (height / 100) * 22
#     else:
#         return (height / 100) * (height / 100) * 21

# std = std_weight(height, gender)

# print("키 {0} {1}의 표준 체중은 {2: .2f} 입니다.".format(height, gender, std))


# Quiz)
# for i in range(1, 51):
#     with open(str(i) + "주차.txt", "w", encoding="utf8") as report_file:
#         report_file.write("- {0} 주차 주간 보고 -".format(i))
#         report_file.write("\n부서 : ")
#         report_file.write("\n이름 : ")
#         report_file.write("\n업무 요약 : ")





































