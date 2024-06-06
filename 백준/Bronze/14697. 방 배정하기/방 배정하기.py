# 방 배정하기
def can_allocated_rooms(A,B,C,N):
    for i in range (N // A + 1):
        for j in range ((N - i * A) // B + 1):
            if (N - i*A - j*B) % C == 0:
                return 1
    return 0

A,B,C,N = map(int, input().split())
print(can_allocated_rooms(A,B,C,N))