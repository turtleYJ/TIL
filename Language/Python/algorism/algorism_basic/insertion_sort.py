# Insertion Sort
# 이미 정렬된 부분과 비교하여 적절한 위치에 삽입하는 정렬 알고리즘
# 시간복잡도: O(n^2)

def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i-1
        while j >= 0 and key < arr[j]:
            arr[j+1] = arr[j]
            j -= 1
        arr[j+1] = key
    return arr

# 예제 사용
arr = [12, 11, 13, 5, 6]
sorted_arr = insertion_sort(arr)
print("Sorted array:", sorted_arr)