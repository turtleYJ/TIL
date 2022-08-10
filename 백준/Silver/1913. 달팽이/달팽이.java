import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int y = -1;
        int x = 0;
        int j = 0;
        StringBuilder sb1 = new StringBuilder();
        for (int i = N * N; i > 0; i--) {
            int ny = y + dy[j];
            int nx = x + dx[j];

            if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] == 0) {
                map[ny][nx] = i;
                y = ny;
                x = nx;
                if (i == M) {
                    sb1.append((ny + 1) + " " + (int) (nx + 1));
                }
            } else {
                j++;
                j %= 4;
                i++;
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for (int[] ints : map) {
            for (int i : ints) {
                sb2.append(i + " ");
            }
            sb2.append('\n');
        }

        System.out.print(sb2);
        System.out.print(sb1);
    }
}