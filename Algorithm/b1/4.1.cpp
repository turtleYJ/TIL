#include <iostream>
using namespace std;

// 주어진 배열에서 가장 많이 등장하는 숫자를 반환하기
int majority1(const vector<int>& A) {
    int N = A.size();
    int majority = -1, majorityCnt = 0;
    for (size_t i = 0; i < N; i++)
    {
        int V = A[i], count = 0;
        for (size_t j = 0; j < N; j++)
        {
            if (A[j] == V)
            {
                count++;
            }
        }
        if (count > majorityCnt) {
            majorityCnt = count;
            majority = V;
        }
    }
    return majority;
}