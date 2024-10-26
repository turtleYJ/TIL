# include <iostream>
using namespace std;

// 포인터 사용의 예
// 3. 포인터와 배열
int main() {
    int arr[3] = {10, 20, 30};
    int* ptr = arr;

    for (int i = 0; i < 3; i++) {
        cout << *(ptr + i) << endl;
    }

    return 0;
}