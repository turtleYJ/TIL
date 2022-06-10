import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while(true) {
			sb.append(q.poll() + " ");
			if(q.isEmpty()) break;
			q.offer(q.poll());
		}
		
		System.out.println(sb);
		
	}
}