import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				return Math.abs(o1) - Math.abs(o2);
			}
			
		});
		
		int num = 0;
		StringBuilder sb = new StringBuilder();
		while(N-- > 0) {
			num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				Integer extr = pq.poll();
				if (extr == null) sb.append(0).append('\n');
				else sb.append(extr).append('\n');
			} else {
				pq.offer(num);
			}
		}
		System.out.println(sb);
	}
}