import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[5][5];
        StringTokenizer st = null;
        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                delete(num, board);
                cnt++;

                int cntBingo = countBingo(board);

                if (cntBingo >= 3) {
                    System.out.println(cnt);

                    return;
                }
            }
        }

    }

    private static int countBingo(int[][] board) {
        int cntRow = 0;
        int cntCol = 0;
        int diagoanl = 0;

        // 행
        for (int i = 0; i < board.length; i++) {
            boolean isBingo = true;

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != -1) {
                    isBingo = false;

                    break;
                }
            }

            if (isBingo) {
                cntRow++;
            }
        }

        // 열
        for (int i = 0; i < board[0].length; i++) {
            boolean isBingo = true;

            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != -1) {
                    isBingo = false;

                    break;
                }
            }

            if (isBingo) {
                cntCol++;
            }
        }
        
        // 대각선
        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != -1) {
                isBingo = false;

                break;
            }
        }

        if (isBingo) {
            diagoanl++;
        }

        isBingo = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][4 - i] != -1) {
                isBingo = false;

                break;
            }
        }

        if (isBingo) {
            diagoanl++;
        }
        return cntRow + cntCol + diagoanl;
    }

    private static void delete(int num, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == num) {
                    board[i][j] = -1;

                    return;
                }
            }
        }
    }
}
