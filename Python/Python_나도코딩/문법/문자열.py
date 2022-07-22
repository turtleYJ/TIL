# 문자열
# print('풍선')
# print("나비")
# print("ㅋㅋㅋㅋㅋ")
# print('ㅋ'*9)

# sentence = '나는 소년입니다.'
# print(sentence)
# sentence2 = "나는 소년입니다."
# print(sentence2)
# sentence3 = """
# 나는 소년이고,
# 파이썬은 쉬워요
# """
# print(sentence3)

# # 문자열 처리
# python = "Python is Amazing"
# print(python.lower())
# print(python.upper())
# print(python[0].isupper())
# print(len(python))
# print(python.replace("Python", "Java"))

# index = python.index("n")
# print(index)
# index = python.index("n", index + 1)
# print(index)

# print(python.find("Java"))
# # print(python.index("Java"))

# print(python.count("n"))


# 문자열 포맷
# print("a" + "b")
# print("a", "b")

# 방법 1
# print("나는 %d살입니다." % 20)
# print("나는 %s를 좋아해요." % "파이썬")
# print("Apple 은 %c로 시작해요." % 'A')

# %s로 다 대체할 수 있다?
# print("나는 %s살입니다." % 20)
# print("나는 %s를 좋아해요." % "파이썬")
# print("Apple 은 %s로 시작해요." % 'A')

# print("나는 %s색과 %s색을 좋아해요" % ("파란", "빨간"))

# # 방법 2
# print("나는 {}살입니다.".format(20))
# # 인덱스를 부여한다.
# print("나는 {0}색과 {1}색을 좋아해요".format("파란", "빨간"))
# print("나는 {1}색과 {0}색을 좋아해요".format("파란", "빨간"))

# # 방법 3
# print("나는 {age}살이며, {color}색을 좋아해요.".format(age = 20, color = "빨간"))
# print("나는 {age}살이며, {color}색을 좋아해요.".format(color = "빨간", age = 20))

# # 방법 4
# age = 20
# color = "빨간"
# print(f"나는 {age}살이며, {color}색을 좋아해요.")

# 탈출 문자
# \n : 줄바꿈
# print("백문이 불여일견 \n백견이 불여일타")

# 저는 "나도코딩"입니다.
# print("저는 "나도코딩"입니다.")
# \" \' : 문장 내에서 따옴표
# print("저는 '나도코딩'입니다.")
# print('저는 "나도코딩"입니다.')
# print("저는 \"나도코딩\"입니다.")

# \\ : 문장 내에서 \
# print("C:\\git_repasitory\\Study")

# \r : 커서를 맨 앞으로 이동
# print("Red Apple\rPine") # PineApple

# \b : 백스페이스 (한 글자 삭제)
# print("Redd\bApple") # RedApple

# \t : 탭
# print("Red\tApple")