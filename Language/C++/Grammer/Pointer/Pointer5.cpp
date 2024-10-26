# include <iostream>
using namespace std;

// 포인터 사용의 예
// 4. 이중 포인터(Pointer to Pointer)
int main() {
    int a = 5;
    int* ptr = &a;
    int** ptr2 = &ptr;

    cout << **ptr2 << endl;

    return 0;
}