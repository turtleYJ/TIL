#include <iostream>
using namespace std;

// 최대 연속 부분 구간 합 알고리즘 2
// A[lo..hi]의 연속된 부분 구간의 최대 합을 구한다. 시간 복잡도: O(nlgn)
const int MIN = numeric_limits<int>::min();
int fastMaxSum(const vector<int>& A, int lo, int hi) {
    // 기저 사례: 구간의 길이가 1일 경우
    if(lo == hi) return A[lo];
    // 배열을 A[lo..mid], A[mid+1..hi] 두 조각으로 나눈다.
    int mid = (lo + hi) / 2;
    // 두 부분에 모두 걸쳐 있는 최대 합 구간을 찾는다. 이 구간은
    // A[i..mid]와 A[mid+1..j] 형태를 갖는 구간의 합으로 이루어진다.
    // A[i..mid] 형태를 갖는 최대 구간을 찾는다.
    int left = MIN, right = MIN, sum = 0;
    for (int i = mid; i >= lo; i--)
    {
        sum += A[i];
        left = max(left, sum);
    }
    // A[mid+1..j] 형태를 갖는 최대 구간을 구한다.
    sum = 0;
    for (int j = mid+1; j <= hi; j++)
    {
        sum += A[j];
        right = max(right, sum);
    }
    // 최대 구간이 두 조각 중 하나에만 속해 있는 경우의 답을 재귀 호출로 찾는다.
    int single = max(fastMaxSum(A, lo, mid), fastMaxSum(A, mid+1, hi));

    return max(left + right, single);
}

int main() {
    vector<int> arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int maxSum = fastMaxSum(arr, 0, arr.size() - 1);
    cout << "Maximum subarray sum is " << maxSum << endl;
    return 0;
}