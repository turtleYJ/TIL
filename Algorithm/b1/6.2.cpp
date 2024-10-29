#include <iostream>
using namespace std;

void printPicked(vector<int>& picked) {
    for (int i = 0; i < picked.size(); i++) {
        cout << picked[i] << " ";
    }
    cout << endl;
}

// n: 전체 원소의 수
// picked: 지금까지 고른 원소들의 번호
// toPick: 더 고를 원소의 수
void pick(int n, vector<int>& picked, int toPick) {
    if (toPick == 0) {
        printPicked(picked);
        return;
    }

    // int smallest = picked.size() > 0 ? picked.back() + 1 : 0;
    int smallest = picked.empty() ? 0 : picked.back() + 1;

    for (int i = smallest; i < n; i++) {
        picked.push_back(i);
        pick(n, picked, toPick-1);
        picked.pop_back();
    }
}

int main() {
    int n = 5;      // 전체 원소의 수
    int toPick = 3; // 고를 원소의 수
    vector<int> picked;

    pick(n, picked, toPick);

    return 0;
}