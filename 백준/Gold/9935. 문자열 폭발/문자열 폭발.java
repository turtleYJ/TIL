import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String exp = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			
			if (stack.size() >= exp.length()) {
				boolean pass = true;
				
				for (int j = 0; j < exp.length(); j++) {
					if (stack.get(stack.size() - exp.length() + j) != exp.charAt(j)) {
						pass = false;
						break;
					}
				}
				if (pass) {
					for (int j = 0; j < exp.length(); j++) {
						stack.pop();
					}
				}
				
			}
		}
		
		if (stack.isEmpty()) {
			System.out.println("FRULA");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for (Character ch : stack) {
			sb.append(ch);
		}
		System.out.println(sb);
	}
}