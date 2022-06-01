import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// stack
// 괄호
// 영어버전
public class Main {

	public static void main(String[] args) throws IOException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		Deque<int[]> dq = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			
			arr[i][0] = i;
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			dq.offer(arr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			int[] temp = dq.pollFirst();
			sb.append(temp[0] + " ");
			
			if(dq.isEmpty()) break;
			
			int M = temp[1];
			
			if(M > 0) {
				
				for(int i = 0; i < M - 1; i++) {
					
					dq.offerLast(dq.pollFirst());
				}
				
			} else {
				
				for(int i = 0; i < -M; i++) {
					
					dq.offerFirst(dq.pollLast());
				}
			}
			
		}
		
		System.out.println(sb);
    }
}