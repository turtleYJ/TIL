import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[N];
        int state = 0; // -1 : down, 0 : neutral, 1 : up

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int cnt1 = 1;  // up방향
        int cnt2 = 1;  // down방향
        int res = 1;
        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] == sequence[i - 1]) {
                cnt1++;
                cnt2++;
            } else if (sequence[i] > sequence[i - 1]) {
                cnt1++;
                cnt2 = 1;

            } else {
                cnt2++;
                cnt1 = 1;
            }

            res = Math.max(Math.max(cnt1, cnt2), res);
        }

        System.out.println(res);
    }
}