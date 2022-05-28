import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<String> list = new ArrayList<>();
        
        for(int i = 0 ; i < N + M; i++) {
        	
        	list.add(br.readLine());
        }
        
        Collections.sort(list);
        
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < list.size(); i++) {

        	if(i > 0) {
        		
        		if(list.get(i).equals(list.get(i - 1))) {
        			
        			count++;
        			
        			sb.append(list.get(i)).append('\n');
        		}
        	}
        }
        
        System.out.println(count);
        System.out.println(sb);
    }
}