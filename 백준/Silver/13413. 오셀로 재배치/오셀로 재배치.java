import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 동일한 문자열의 개수 파악
// Map을 이용
public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
        	
        	int N = Integer.parseInt(br.readLine());
        	
        	String S1 = br.readLine();
        	String S2 = br.readLine();
        	
        	int countB = 0;
        	int countW = 0;
        	
        	
        	for(int i = 0; i < N; i++) {
        		
        		if(S1.charAt(i) != S2.charAt(i)) {
        			
        			if(S1.charAt(i) == 'B') {
        				countB++;
        			}
        			
        			if(S1.charAt(i) == 'W') {
        				countW++;
        			}
        		}
        	}
        	
        	int total = countW + countB;
        	
        	System.out.println(total - Math.min(countW, countB));
        }
    }
}