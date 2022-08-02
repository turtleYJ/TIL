import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			Integer[] arr = new Integer[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
			
			Deque<Integer> dq = new ArrayDeque<>();
			
			for (int i = 0; i < arr.length; i++) {
				if (i % 2 == 0) {
					dq.addFirst(arr[i]);
				} else {
					dq.addLast(arr[i]);
				}
			}
			
 			int res = 0;
			int size = dq.size();
			for (int i = 0; i < size - 1; i++) {
				int n1 = 0;
				int n2 = 0;
				if (i == 0) {
					n1 = dq.pollFirst();
					n2 = dq.peekLast();
					res = Math.max(res, Math.abs(n1 - n2));
					
					n2 = dq.peekFirst();
					res = Math.max(res, Math.abs(n1 - n2));
				} else {
					n1 = dq.pollFirst();
					n2 = dq.peekFirst();
					res = Math.max(res, Math.abs(n1 - n2));
				}
				
			}
			
			System.out.println(res);
		}
	}
}