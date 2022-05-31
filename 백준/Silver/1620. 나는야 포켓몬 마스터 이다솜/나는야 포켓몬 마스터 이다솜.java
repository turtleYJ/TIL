import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> sMap = new HashMap<>();
        Map<Integer, String> intMap = new HashMap<>();
        
        for(int i = 1; i <= N; i++) {
        	
        	String S = br.readLine();
        	
        	sMap.put(S, i);
        	intMap.put(i, S);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++) {
        	
        	String S = br.readLine();
        
        	boolean isNumeric = S.matches("[+-]?\\d*(\\.\\d+)?");
        	
        	if(isNumeric) {
        		
        		sb.append(intMap.get(Integer.parseInt(S))).append('\n');
        	} else {
        		
        		sb.append(sMap.get(S)).append('\n');
        	}
        }
        
        System.out.println(sb);
    }
}