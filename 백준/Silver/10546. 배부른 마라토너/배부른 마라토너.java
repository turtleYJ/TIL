import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Map<String, Integer> name = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
        	
        	String S = br.readLine();
        	
        	name.put(S, name.getOrDefault(S, 0) + 1);
        }
        
        for(int i = 0; i < N - 1; i++) {
        	
        	String S = br.readLine();
        	
        	name.put(S, name.get(S) - 1);
        }
        
        for (String S : name.keySet()) {
			
        	if(name.get(S) != 0) {
        		
        		System.out.println(S);
        	}
		}
    }
}