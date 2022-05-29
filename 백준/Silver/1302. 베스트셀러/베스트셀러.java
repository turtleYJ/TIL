import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 동일한 문자열의 개수 파악
public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 0 ;
        N = Integer.parseInt(br.readLine());
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < N; i++) {
        	String S = br.readLine();
        	
        	if(!map.containsKey(S)) {
        		
        		map.put(S, 1);
        	} {
        		
        		map.put(S, map.get(S) + 1);
        	}
        }
        
        int max = Integer.MIN_VALUE;
        String bestSeller = "";
        
        for (String key : map.keySet()) {
        	int value = map.get(key);
        	
        	if(value == max && bestSeller.compareTo(key) > 0) {
        		
        		bestSeller = key;
        		
        	} else if(value > max) {
        		
        		max = value;
        		
        		bestSeller = key;
        	}
		}
        
        System.out.println(bestSeller);
    }
}