import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 에디터
// 키로거
// stack을 이용한 키보드 입출력
public class Main {

	public static void main(String[] args) throws IOException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			
			String S = br.readLine();
			
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			
			for(int i = 0; i < S.length(); i++) {
				
				char tempC = S.charAt(i);
				
				switch (tempC) {
				case '<':
					if(left.size() != 0) {
						
						right.add(left.pop());
					}
					
					break;
				case '>':
					if(right.size() != 0) {
						
						left.add(right.pop());
					}
					
					break;
				case '-':
					if(left.size() != 0) {
						
						left.pop();
					}
					
					break;
					
				default:
					left.add(tempC);
					
					break;
				}
			}
			
			while(!left.isEmpty()) {
				right.add(left.pop());
			}
			while(!right.isEmpty()) {
				sb.append(right.pop());
			}
			
			sb.append('\n');
		}
		
		System.out.println(sb);
    }
}