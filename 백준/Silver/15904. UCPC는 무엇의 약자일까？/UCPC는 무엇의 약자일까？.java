import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = br.readLine();
        int N = S.length();
        
        int count = 0; // 1- U, 2 -- C, 3 -- P, 4 -- C,
        
        int i = -1;
        while(++i < N) {
        	
//        	String S = st.nextToken();
        	
        	if(count == 0 && S.charAt(i) == 'U') {
        		
        		count++;
        		
        		continue;
        	}
        	
        	if(count == 1 && S.charAt(i) == 'C') {
        		
        		count++;
        		
        		continue;
        	}
        	
        	if(count == 2 && S.charAt(i) == 'P') {
        		
        		count++;
        		
        		continue;
        	}
        	
        	if(count == 3 && S.charAt(i) == 'C') {
        		
        		count++;
        		
        		continue;
        	}
        	
        	
        }
        
        if(count == 4) {
        	
        	System.out.println("I love UCPC");
        } else {
        	
        	System.out.println("I hate UCPC");
        }
    }
}