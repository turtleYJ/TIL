import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(T-- > 0) {
        	
        	Map<String, Boolean> check = new HashMap<>();
        	
        	int N = Integer.parseInt(br.readLine());
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i < N; i++) {
        		
        		check.put(st.nextToken(), true);
        	}
        	
        	int M = Integer.parseInt(br.readLine());
        	
        	st = new StringTokenizer(br.readLine());
        	
        	for(int i = 0; i < M; i++) {
        		
        		if(check.getOrDefault(st.nextToken(), false)) {
        			
        			sb.append(1).append('\n');
        		} else {
        			
        			sb.append(0).append('\n');
        		}
        	}
        }
        
        System.out.println(sb);
    }
}