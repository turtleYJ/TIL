import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int k = 1;
		
		while(T-- > 0) {
			HashSet<String> seen = new HashSet<>();
			boolean correct = true;
			
			roof:
			for(int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 9; j++) {
					String S = "(" + st.nextToken() + ")";
					if(!seen.add(i + S) || !seen.add(S + j) || !seen.add((i / 3) + S + (j / 3))) {
						correct = false;						
						while(T != 0 && !(br.readLine().equals(""))) {}
						
						break roof;
					}
				}
			}
			
			if(correct) {
				sb.append("Case " + k++ + ": " + "CORRECT").append('\n');
				if(T != 0) br.readLine();
			} else {
				sb.append("Case " + k++ + ": " + "INCORRECT").append('\n');
			}
		}
		System.out.println(sb);
	}
}