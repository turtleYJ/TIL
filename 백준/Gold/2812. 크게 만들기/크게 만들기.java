import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		String exi = br.readLine();
		
		for (int i = 0; i < exi.length(); i++) {
			int n = exi.charAt(i) - 48;
			
			while (!stack.isEmpty() && stack.peek() < n && K > 0) {
				stack.pop();
				K--;
			}
			
			stack.push(n);
		}
		
		while (K > 0) {
			stack.pop();
			K--;
		}
		
		StringBuilder sb = new StringBuilder();
		for (Integer i : stack) {
			sb.append(i);
		}
		
		System.out.println(sb);
	}
}
