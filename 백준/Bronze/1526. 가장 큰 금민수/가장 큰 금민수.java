import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = 0;
        
        N = Integer.parseInt(br.readLine());
        
        int result = Integer.MIN_VALUE;
        
        for(int i = 1; i <= N; i++) {
        	
        	String S = Integer.toString(i);
        	boolean OK = true;
        	
        	for(int j = 0; j < S.length(); j++) {
        		
        		if(S.charAt(j) != '4' && S.charAt(j) != '7') {
        			OK = false;
        			
        			break;
        		}
        	}
        	
        	if(OK) {
        		result = Integer.parseInt(S);
        	}
        }
        
        System.out.println(result);
    }
}