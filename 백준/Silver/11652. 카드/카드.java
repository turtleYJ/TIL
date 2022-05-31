import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Map<Long, Integer> map = new HashMap<>();
        
        int maxVal = 0;
        long maxKey = 0;
        
        for(int i = 0; i < N; i++) {
        	
        	long tempKey = Long.parseLong(br.readLine());
        	
    		map.put(tempKey, map.getOrDefault(tempKey, 0) + 1);
    		
    		int tempVal = map.get(tempKey);
    		
    		if(map.get(tempKey) > maxVal) {
    			
    			maxVal = tempVal;
    			maxKey = tempKey;
    		} else if (tempVal == maxVal) {
    			
    			maxKey = Math.min(maxKey, tempKey);
    		}
        }
        
        System.out.println(maxKey);
    }
}