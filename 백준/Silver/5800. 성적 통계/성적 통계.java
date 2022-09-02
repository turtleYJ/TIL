import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int k = 1;
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] sequence = new int[n];

            for (int i = 0; i < sequence.length; i++) {
                sequence[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(sequence);

            int max = 0;
            for (int i = 0; i < sequence.length - 1; i++) {
                int diff = Math.abs(sequence[i] - sequence[i + 1]);
                max = Math.max(max, diff);

            }

            System.out.println("Class " + k++);
            System.out.println("Max " + sequence[sequence.length - 1] + ", Min " + sequence[0] + ", Largest gap " + max);
        }
    }
}
