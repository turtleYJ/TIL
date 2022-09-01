import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()); // 관객의 대기번호

        if (K > R * C) {
            System.out.println(0);

            return;
        }

        int dir = 0; // 0 - 북, 1 - 동, 2 - 남, 3 - 서
        int[][] seats = new int[R + 1][C + 1];

        int r = R;
        int c = 1;
        seats[r][c] = 1;
        for (int i = 2; i <= R * C; i++) {
            switch (dir) {
                case 0:
                    r--;

                    break;
                case 1:
                    c++;

                    break;
                case 2:
                    r++;

                    break;
                case 3:
                    c--;

                    break;
            }

            if (c < 1 || r < 1 || c > C || r > R || seats[r][c] != 0) {
                int[] position = rollback(dir, r, c);
                r = position[0];
                c = position[1];
                dir++;
                dir %= 4;
                i--;

                continue;
            }

            seats[r][c] = i;
        }

        int y = 0;
        int x = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (seats[i][j] == K) {
                    y = R + 1 - i;
                    x = j;

                    break;
                }

            }
        }

        System.out.println(x + " " + y);




    }

    private static int[] rollback(int dir, int r, int c) {
        switch (dir) {
            case 0:
                r++;

                break;
            case 1:
                c--;

                break;
            case 2:
                r--;

                break;
            case 3:
                c++;

                break;
        }

        return new int[]{r, c};
    }
}
