# include <iostream>
using namespace std;

// 포인터 사용의 예
// 1. 함수 인자로 포인터 전달 (Call by reference)
void swap(int* x, int* y) {
    int temp = *x;
    *x = *y;
    *y = temp;
}

int main() {
    int a = 5;
    int b = 10;
    swap(&a, &b);
    cout << "a: " << a << ", b: " << b << endl;

    return 0;
}