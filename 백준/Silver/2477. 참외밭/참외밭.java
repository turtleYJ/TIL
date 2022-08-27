import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int horMax = 0;
        int verMax = 0;
        int[][] side = new int[6][2];

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            side[i][0] = dir;
            side[i][1] = len;

            if (dir == 1 || dir == 2) {
                horMax = Math.max(horMax, len);
            } else {
                verMax = Math.max(verMax, len);
            }
        }

        int area1 = 0;
        int ver = 0;
        for (int i = 0; i < side.length; i++) {
            if (side[i][1] == horMax) {
                int right = i + 1;
                if (right > 5) right -= 6;
                int left = i - 1;
                if (left < 0) left += 6;

                ver = Math.min(side[left][1], side[right][1]);
                area1 = horMax * ver;
            }
        }

        int area2 = 0;
        int hor = 0;
        for (int i = 0; i < side.length; i++) {
            if (side[i][1] == verMax) {
                int right = i + 1;
                if (right > 5) right -= 6;
                int left = i - 1;
                if (left < 0) left += 6;

                hor = Math.min(side[left][1], side[right][1]);
                area2 = (verMax - ver) * hor;
            }
        }

        int res = (area1 + area2) * K;

        System.out.println(res);
    }
}