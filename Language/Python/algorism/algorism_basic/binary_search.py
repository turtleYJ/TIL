# Binary Search
# 이진 탐색 알고리즘
# 탐색 범위를 반으로 좁혀가며 빠르게 탐색하는 알고리즘
# 이진 탐색은 배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘
# 시간 복잡도 O(logN) 간단하게 설명하면, 탐색할 데이터의 개수가 2배로 늘어날 때마다 시간이 1씩 증가한다.

def binary_search(arr, target):
    low = 0
    high = len(arr) - 1
    mid = 0

    while low <= high:
        mid = (high + low) // 2

        # target이 중간 값보다 큰 경우, 오른쪽 반 탐색
        if arr[mid] < target:
            low = mid + 1
        # target이 중간 값보다 작은 경우, 왼쪽 반 탐색
        elif arr[mid] > target:
            high = mid - 1
        # target이 중간 값과 같은 경우, 인덱스 반환
        else:
            return mid
        
    return -1

# 예제 사용
arr = [2, 3, 4, 10, 40]
target = 10
result = binary_search(arr, target)

if result != -1:
    print("Element is present at index", str(result))
else:
    print("Element is not present in array")