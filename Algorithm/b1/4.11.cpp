#include <iostream>
using namespace std;

// 최대 연속 부분 구간 합 알고리즘 3
// A[]의 연속된 부분 구간의 최대 합을 구한다. 시간 복잡도: O(N)
// 점화식: maxAt(i) = max(maxAt(i-1), 0) + A[i]
const int MIN = numeric_limits<int>::min();
int fastestMaxSum(const vector<int>& A) {
    int N = A.size(), ret = MIN, psum = 0;
    for(int i = 0; i < N; i++) {
        psum = max(psum, 0) + A[i];
        ret = max(ret, psum);
    }

    return ret;
}

int main() {
    vector<int> arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int maxSum = fastestMaxSum(arr);
    cout << "Maximum subarray sum is " << maxSum << endl;
    return 0;
}