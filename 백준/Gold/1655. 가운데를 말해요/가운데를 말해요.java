import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> ascendingHeap = new PriorityQueue<>();
        PriorityQueue<Integer> desendingHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (ascendingHeap.size() == desendingHeap.size()) {
                desendingHeap.offer(num);
            } else {
                ascendingHeap.offer(num);
            }

            if (!desendingHeap.isEmpty() && !ascendingHeap.isEmpty()) {
                while (desendingHeap.peek() > ascendingHeap.peek()) {
                    ascendingHeap.offer(desendingHeap.poll());
                    desendingHeap.offer(ascendingHeap.poll());
                }
            }

            sb.append(desendingHeap.peek()).append('\n');
        }

        System.out.println(sb);
    }
}