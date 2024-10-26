# include <iostream>
using namespace std;

int main() {
    int a = 5;
    int* ptr = &a;

    cout << "a의 값: " << a << endl;
    cout << "a의 주소: " <<  &a << endl;
    cout << "ptr이 가리키는 값: " << *ptr << endl;
    cout << "ptr 자체의 값(주소): " << ptr << endl;

    return 0;
}