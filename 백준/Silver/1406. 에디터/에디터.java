import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String S = br.readLine();
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for(int i = 0; i < S.length(); i++) {
			left.add(S.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		while(M-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char tempC = st.nextToken().charAt(0);
			
			switch (tempC) {
			case 'L':
				if(left.size() != 0) {
					
					right.add(left.pop());
				}
				
				break;
			case 'D':
				if(right.size() != 0) {
					
					left.add(right.pop());
				}
				
				break;
			case 'B':
				if(left.size() != 0) {
					
					left.pop();
				}
				
				break;
			case 'P':				
				left.add(st.nextToken().charAt(0));
				
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!left.isEmpty()) {
			right.add(left.pop());
		}
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb);
		
    }
}