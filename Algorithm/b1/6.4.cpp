#include <iostream>
using namespace std;
int n;
bool areFriends[10][10];
int countParings(bool taken[10]) {
    int firstFree = -1;
    for (int i = 0; i < n; i++) {
        if (!taken[i]) {
            firstFree = i;
            break;
        }
    }
    if (firstFree == -1) return 1;
    int ret = 0;
    for (int pairWith = firstFree + 1; pairWith < n; pairWith++) {
        if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
            taken[firstFree] = taken[pairWith] = true;
            ret += countParings(taken);
            taken[firstFree] = taken[pairWith] = false;
        }
    }
    return ret;
}

int main() {
    int C;
    cin >> C;

    for (int t = 0; t < C; t++) {
        int m;
        cin >> n >> m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                areFriends[i][j] = false;
            }
        }

        for (int i = 0; i < m; i ++) {
            int a, b;
            cin >> a >> b;
            areFriends[a][b] = true;
            areFriends[b][a] = true;
        }

        bool taken[10] = {false};

        cout << countParings(taken) << endl;
    }
    return 0;
}