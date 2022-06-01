import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// stack
// 괄호
// 영어버전
public class Main {

	public static void main(String[] args) throws IOException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			
			Stack<Character> stack = new Stack<>();
			String S = br.readLine();
			
			for(int j = 0; j < S.length(); j++) {
				
				char c = S.charAt(j);
				
				switch (c) {
				case 'A':

					if(stack.size() > 0 && stack.peek() == 'A') {
						
						stack.pop();
					} else {
						
						stack.add(c);
					}
					
					break;
				case 'B':
					
					if(stack.size() > 0 && stack.peek() == 'B') {
						
						stack.pop();
					} else {
						
						stack.add(c);
					}
					
					break;
				}
			}
			
			
			if(stack.isEmpty()) {
				count++;
			}
		}
		
		System.out.println(count);
    }
}