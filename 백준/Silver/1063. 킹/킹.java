import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String positionK = st.nextToken();
        String positionS = st.nextToken();
        int moveCNT = Integer.parseInt(st.nextToken());
        int[][] board = new int[9][9];

        // king : 1, stone : -1
        int colK = positionK.charAt(0) -64;
        int rowK = positionK.charAt(1) - 48;
        rowK = 9 - rowK;

        board[rowK][colK] = 1;

        int colS = positionS.charAt(0) -64;
        int rowS = positionS.charAt(1) - 48;
        rowS = 9 - rowS;

        board[rowS][colS] = -1;

        /*
        R : 한 칸 오른쪽으로
        L : 한 칸 왼쪽으로
        B : 한 칸 아래로
        T : 한 칸 위로
        RT : 오른쪽 위 대각선으로
        LT : 왼쪽 위 대각선으로
        RB : 오른쪽 아래 대각선으로
        LB : 왼쪽 아래 대각선으로
         */
        while (moveCNT-- > 0) {
            String dir = br.readLine();
            int nr = 0;
            int nc = 0;
            int[] position = new int[]{rowK, colK};
            int[] newPosition = new int[2];

            newPosition = move(position, dir);

            if (newPosition == null) continue;

            nr = newPosition[0];
            nc = newPosition[1];

            if (board[nr][nc] == -1) {
                int nrS = 0;
                int ncS = 0;
                int[] newStonePosition = new int[2];
                newStonePosition = move(new int[]{nr, nc}, dir);

                if (newStonePosition == null) continue;

                nrS = newStonePosition[0];
                ncS = newStonePosition[1];

                // 돌의 위치 변경
                board[nrS][ncS] = -1;
                board[nr][nc] = 0;

                rowS = nrS;
                colS = ncS;
            }

            board[nr][nc] = 1;
            board[rowK][colK] = 0;

            rowK = nr;
            colK = nc;
        }

        String resK = "" + (char)(colK + 64) + (9 - rowK);
        String resS = "" + (char)(colS + 64) + (9 - rowS);

        System.out.println(resK);
        System.out.println(resS);
    }

    private static int[] move(int[] position, String dir) {
        int row = position[0];
        int col = position[1];


        switch (dir) {
            case "R":
                col = col + 1;

                break;
            case "L":
                col = col - 1;

                break;
            case "B":
                row = row + 1;

                break;
            case "T":
                row = row - 1;

                break;
            case "RT":
                row = row - 1;
                col = col + 1;

                break;
            case "LT":
                row = row - 1;
                col = col - 1;

                break;
            case "RB":
                row = row + 1;
                col = col + 1;

                break;
            case "LB":
                row = row + 1;
                col = col - 1;

                break;
        }

        if (row > 0 && col > 0 && row < 9 && col < 9) return new int[]{row, col};
        else return null;
    }
}
