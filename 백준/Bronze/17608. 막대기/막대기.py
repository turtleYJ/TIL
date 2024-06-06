import sys 

def count_visible_rods(heights):
    key = 0
    count = 0
    for height in reversed(heights):
        if (height > key):
            count += 1
            key = height
    return count


input = sys.stdin.read
data = input().splitlines()  # 전체 입력을 줄 단위로 나눕니다.
N = int(data[0])
heights = list(map(int, data[1:]))

print(count_visible_rods(heights))