#include <iostream>
using namespace std;

// 최대 연속 부분 구간 합 알고리즘 1
const int MIN = numeric_limits<int>::min();
// A[]의 연속된 부분 구간의 최대합을 구한다. 시간 복잡도: O(N^3)
int inefficientMaxSum(const vector<int>& A) {
    int N = A.size(), ret = MIN;
    for (size_t i = 0; i < N; i++)
    {
        for (size_t j = i; j < N; j++)
        {
            int sum = 0;
            for (size_t k = 0; k <= j; k++)
            {
                sum += A[k];
            }
            ret = max(ret, sum);
        }
    }
    return ret;
}