import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            BigInteger cnt = combination(M, N);

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    private static BigInteger combination(int n, int m) {
        BigInteger factNminusM = new BigInteger(String.valueOf(1));
        BigInteger top = new BigInteger(String.valueOf(1));

        for (int i = n; i > m; i--) {
            top = top.multiply(new BigInteger(String.valueOf(i)));
        }

        for (int i = 1; i <= n - m; i++) {
            factNminusM = factNminusM.multiply(new BigInteger(String.valueOf(i)));
        }

        BigInteger res = top.divide(factNminusM);

        return res;
    }
}