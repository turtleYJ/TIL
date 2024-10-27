#include <iostream>
using namespace std;

// 실수 배열 A가 주어질 때, 각 위치에서 M-이동 평균 값을 구한다.
vector<double> movingAverage1(const vector<double> A, int M) {
    vector<double> ret;
    int N = A.size();
    for (size_t i = M-1; i < N; i++)
    {
        // M이 3이라면 i는 2부터 시작
        double partialSum = 0;
        for (size_t j = 0; j < M; j++)
        {
            partialSum += A[i-j];
        }
        ret.push_back(partialSum/M);
    }
    return ret;
}

int main() {
    // 테스트 케이스 1
    vector<double> A1 = {1.0, 2.0, 3.0, 4.0, 5.0};
    int M1 = 3;
    vector<double> result1 = movingAverage1(A1, M1);
    cout << "Test Case 1: ";
    for (double val : result1) cout << val << " ";
    cout << endl;

    // 테스트 케이스 2
    vector<double> A2 = {5.5, 6.5, 7.5, 8.5, 9.5};
    int M2 = 2;
    vector<double> result2 = movingAverage1(A2, M2);
    cout << "Test Case 2: ";
    for (double val : result2) cout << val << " ";
    cout << endl;

    // 테스트 케이스 3
    vector<double> A3 = {10.0, 20.0, 30.0, 40.0, 50.0, 60.0};
    int M3 = 4;
    vector<double> result3 = movingAverage1(A3, M3);
    cout << "Test Case 3: ";
    for (double val : result3) cout << val << " ";
    cout << endl;

    return 0;
}