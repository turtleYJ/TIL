import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<int []> st = new Stack<>();
		
		long res = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (!st.isEmpty()) {
				if (st.peek()[0] <= num) {
					while (!st.isEmpty() && st.peek()[0] < num) {
						res += st.peek()[1];
						st.pop();
					}
					if (!st.isEmpty() && st.peek()[0] == num) {
						res += st.peek()[1];
						st.peek()[1]++;
						
						if (st.size() > 1) {
							res++;
						}
						
						continue;
					}
					if (!st.isEmpty()) {
						res++;
					}
				} else {
					res++;
				}
				
				
			}
			
//			if (!st.isEmpty()) {
//				if (st.peek() <= num) {
//					while (!st.isEmpty() && st.peek() < num) {
//						st.pop();
//						res++;
//					}
//					if (st.peek() == num) 
//					for (int j = st.size() - 1; j >= 0 ; j--) {
//						if (st.get(j) == num) {
//							res++;
//						} else {
//							res++;
//							break;
//						}
//							
//					}
//				} else {
//					res++;
//				}
//				
//				
//			}
			
			
			st.push(new int[] {num, 1});
		}
		System.out.println(res);
	}
}