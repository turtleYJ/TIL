import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소힙
// PriorityQueue
public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < n; i++) {
			
			pq.offer(Long.parseLong(st.nextToken()));
		}
		
		while(m-- > 0) {
			
			long sum = pq.poll() + pq.poll();
			
			pq.offer(sum);
			pq.offer(sum);
		}
		
		long result = 0;
		
		while(!pq.isEmpty()) {
			result += pq.poll();
		}
		
		System.out.println(result);
	}
}