#include <iostream>
using namespace std;

// 매개변수
// N: 채워야할 도형의 갯수
// board: 흰색 검정색으로 초기화된 보드
// int countCoverings(bool board[20][20], int N) {

// }

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

        int whiteCnt = 0;
        for (int i = 0; i < H; i++) {
            string line;
            getline(cin, line);
            for (int j = 0; j < W; j++) {
                int temp = line[j] == '#' ? 1 : 0;
                if (temp == 0) {
                    whiteCnt += 1;
                }
                board[i][j] = temp;
            }
        }

        cout << "whiteCnt: " << whiteCnt << endl;

        // countCoverings(board, )

        // 입력 확인용 출력 (테스트용)
        // cout << "Test case #" << t + 1 << ":" << endl;
        // cout << "H: " << H << ", W: " << W << endl;
        // for (int i = 0; i < H; i++) {
        //     for (int j = 0; j < W; j++) {
        //         cout << board[i][j];
        //     }
        //     cout << endl;
        // }
    }
} 