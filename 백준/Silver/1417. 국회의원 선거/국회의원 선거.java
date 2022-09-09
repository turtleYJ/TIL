import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int myVotes = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);

            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < N - 1; i++) {
            Integer votes = Integer.parseInt(br.readLine());
            pq.offer(votes);
        }

        int res = 0;
        while (true) {
            int maxVotes = pq.peek();

            if (maxVotes >= myVotes) {
                myVotes++;
                maxVotes = pq.poll() - 1;
                pq.offer(maxVotes);
                res++;
            } else {
                break;
            }
        }

        System.out.println(res);

    }
}
