import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[][] scores = new Integer[8][2];

        for (int i = 0; i < scores.length; i++) {
            scores[i][0] = Integer.parseInt(br.readLine());
            scores[i][1] = i + 1;
        }

        Arrays.sort(scores, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[0] - o1[0];
            }
        });

        int sum = 0;
        int[] problemNums = new int[5];
        for (int i = 0; i < 5; i++) {
            sum += scores[i][0];
            problemNums[i] = scores[i][1];
        }

        Arrays.sort(problemNums);

        System.out.println(sum);
        for (int num : problemNums) {
            System.out.print(num + " ");
        }
    }
}
