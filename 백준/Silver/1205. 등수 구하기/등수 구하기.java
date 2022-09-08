import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int myScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);

            return;
        }

        List<Integer> scoreList = new ArrayList<>();
//        int[] scoreArray = new int[P];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scoreList.add(Integer.parseInt(st.nextToken()));
//            scoreArray[i] = Integer.parseInt(st.nextToken());
        }

        int rank = 1;
        for (int i = 0; i < scoreList.size(); i++) {
            int curScore = scoreList.get(i);

            if (myScore < curScore) {
                rank++;
            } else {
                rank = i + 1;

                break;
            }
        }

        if (N == P) {
            if (rank > P || myScore == scoreList.get(scoreList.size() - 1)) {
                rank = -1;
            }
        }

        System.out.println(rank);
    }
}
