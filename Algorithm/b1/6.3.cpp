#include <iostream>
using namespace std;

const vector<vector<char>> A = {
        {'N', 'N', 'N', 'N', 'S'},
        {'N', 'E', 'E', 'E', 'N'},
        {'N', 'E', 'Y', 'E', 'N'},
        {'N', 'E', 'E', 'E', 'N'},
        {'N', 'N', 'N', 'N', 'N'}
};

const int dx[8] = {1, 1, 1, -1, -1, -1, 0, 0};
const int dy[8] = {-1, 0, 1, -1, 0, 1, -1, 1};

bool inRange(int x, int y) {
    return y >= 0 && y < A.size() && x >= 0 && x < A[0].size();
}

bool hasWord(int x, int y, const string& word) {
    // 기저 사례1: x, y가 범위 밖이면 무조건 false
    if(!inRange(x, y)) return false;
    // 기저 사례2: 첫 글자가 일치하지 않으면 실패
    if(A[x][y] != word[0]) return false;
    // 기저 사례3: 위 분기를 통해 첫 글자가 일치하면서 사이즈가 1이면 성공
    if(word.size() == 1) return true;
    for(int direction = 0; direction < 8; direction++) {
        int nextX = x + dx[direction], nextY = y + dy[direction];
        if(hasWord(nextX, nextY, word.substr(1))) return true;
    }
    return false;
}

int main() {
    string word = "YES";
    if(hasWord(2, 2, word)) {
        cout << word << " exist!" << endl;
    };

    return 0;
}