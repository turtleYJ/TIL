import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringBuilder sb = new StringBuilder();
			
			try {
				int dir = 0; // 0 - forward, 1 - backward
				String S = br.readLine();
				int N = Integer.parseInt(br.readLine());
				StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
				Deque<Integer> dq = new ArrayDeque<>();
				
				for (int i = 0; i < N; i++) {
					dq.offer(Integer.parseInt(st.nextToken()));
				}
				
				for (int i = 0; i < S.length(); i++) {
					char ch = S.charAt(i);
					if(ch == 'R') dir = (dir + 1) % 2;
					if(ch == 'D') {
						Integer poll = 0;
						if(dir == 0) {
							poll = dq.pollFirst();
						} else {
							poll = dq.pollLast();
						}
						if(poll == null) {
							throw new Exception();
						}
					}
				}
				
				if(dq.isEmpty()) {
					System.out.println("[]");
					continue;
				}
				
				sb.append("[");
				
				while(true) {
					if(dir == 0) {
						int n = dq.pollFirst();
						if(dq.isEmpty()) {
							sb.append(n + "]");
							break;
						}
						sb.append(n + ",");
					} else {
						int n = dq.pollLast();
						if(dq.isEmpty()) {
							sb.append(n + "]");
							break;
						}
						sb.append(n + ",");
					}
				}
			} catch (Exception e) {
				System.out.println("error");
				continue;
			}
			System.out.println(sb);
		}
	}
}