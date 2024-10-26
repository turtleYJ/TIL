# include <iostream>
using namespace std;

// 포인터 사용의 예
// 2. 동적 메모리 할당
int main() {
    int* ptr = new int;
    *ptr = 10;
    cout << *ptr << endl;
    delete ptr; // 메모리 해제

    return 0;
}