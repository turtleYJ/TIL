#include <iostream>
using namespace std;

// 매개변수
// N: 채워야할 도형의 갯수
// board: 흰색 검정색으로 초기화된 보드
const int coverType[4][3][2] = {
        {{0, 0}, {1, 0}, {0, 1}},
        {{0, 0}, {1, 0}, {0, -1}},
        {{0, 0}, {-1, 0}, {0, -1}},
        {{0, 0}, {-1, 0}, {0, 1}},
};

// type별로 할당할 위치를 확인하고 문제없으면 set 해줌.
// 반대로 delta가 -1인 경우는 빈칸으로 원복.
bool set(vector<vector<int>>& board, int y, int x, int type, int delta) {
    bool ok = true;
    for (int i = 0; i < 3; i++) {
        const int ny = y + coverType[type][i][0];
        const int nx = x + coverType[type][i][1];
        if (ny < 0 || nx < 0 || ny >= board.size() || nx >= board[0].size()) {
            ok = false;
        } else if ((board[ny][nx] += delta) > 1) {
            ok = false;            
        }
    }
    return ok;
}

int countCoverings(vector<vector<int>>& board) {
    int x, y = -1;
    for (int i = 0; i < board.size(); i++) {
        for (int j = 0; j < board[i].size(); j++) {
            if (board[i][j] == 0) {
                y = i;
                x = j;
                break;
            }
        }
        if (y != -1) break;
    }
    if (x == -1) return 1;
    int ret = 0;
    for (int type = 0; type < 4; type++) {
        if(set(board, y, x, type, 1)) {
            ret += countCoverings(board);
        }        
        set(board, y, x, type, -1);
    }


    return ret;

}

/*
입력
3
3 7
#.....#
#.....#
##...##
3 7
#.....#
#.....#
##..###
8 10
##########
#........#
#........#
#........#
#........#
#........#
#........#
##########
*/
int main() {
    int C;
    cin >> C;

    for (int t = 0; t < C; t++) {
        int H, W;
        cin >> H >> W;
        cin.ignore();

        vector<vector<int>> board(H, vector<int>(W));

        for (int i = 0; i < H; i++) {
            string line;
            getline(cin, line);
            for (int j = 0; j < W; j++) {
                board[i][j] = line[j] == '#' ? 1 : 0;
            }
        }

        int ret = countCoverings(board);

        cout << ret << endl;

        // 입력 확인용 출력 (테스트용)
        // cout << "Test case #" << t + 1 << ":" << endl;
        // cout << "H: " << H << ", W: " << W << endl;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                cout << board[i][j];
            }
            cout << endl;
        }
    }

    return 0;
} 