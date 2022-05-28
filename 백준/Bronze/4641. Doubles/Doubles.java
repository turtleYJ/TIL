import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
        	
        	int count = 0;
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	if(st.countTokens() == 1) {
        		break;
        	}
        	
        	List<Integer> list = new ArrayList<>();
        	
        	
        	int x = 0;
        	
        	while((x = Integer.parseInt(st.nextToken())) != 0) {
        		
        		list.add(x);
        	}
        	
        	for(int i = 0; i < list.size(); i++) {
        		
        		int tempVal = list.get(i);
        		
        		if(list.contains(tempVal *2)) {
        			
        			count++;
        		}
        	}
        	
        	sb.append(count).append('\n');
        }
        
        System.out.println(sb);
    }
}