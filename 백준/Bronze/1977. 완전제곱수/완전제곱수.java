import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = 0;
        int N = 0;
        
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        
        int sum = 0;
        int min = 10001;
        
        for(int i = M; i <= N; i++) {
        	
        	if(Math.sqrt(i) % 1 == 0) {
        		
        		sum += i;
        		
        		min = Math.min(min, i);
        	}
        }
        
        if(min == 10001) {
        	
        	System.out.println(-1);
        } else {
        	
        	System.out.println(sum);
        	System.out.println(min);
        }
    }
}