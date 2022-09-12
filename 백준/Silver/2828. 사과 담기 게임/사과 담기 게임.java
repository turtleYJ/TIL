import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int left = 0;
        int right = 0;

        left = 1;
        right = M;
        int res = 0;

        while (J-- > 0) {
            int position = Integer.parseInt(br.readLine());
            int diff = 0;

            if (position >= left && position <= right) {

                continue;
            }

            if (position < left) {
                diff = left - position;

                left -= diff;
                right -= diff;
                res += diff;
            }

            if (position > right) {
                diff = position - right;

                left += diff;
                right += diff;
                res += diff;
            }
        }

        System.out.println(res);
    }
}
