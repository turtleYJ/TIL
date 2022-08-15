import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sequence);

        System.out.println(sequence[K - 1]);
    }
}