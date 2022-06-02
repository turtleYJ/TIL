import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		HashMap<Integer, Boolean> numMap = new HashMap<>();
		int x = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num <= (x / 2)) {
				pq.offer(num);
			} else {
				numMap.put(num, true);
			}
		}
		
		int count = 0;
		
		while(!pq.isEmpty()) {
			int num1 = pq.poll();
			int num2 = x - num1;
			
			if(num2 <= 0) continue;
			
			if(numMap.getOrDefault(num2, false)) {
				count++;
			}
			
		}
		
		System.out.println(count);
	}
}