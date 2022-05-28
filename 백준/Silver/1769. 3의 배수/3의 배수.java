import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        int count = 0;
        
        while(S.length() != 1) {
        	
        	int temp = 0;
        	
        	for(int i = 0; i < S.length(); i++) {
        		
        		temp += S.charAt(i) - 48;
        	}
        	
        	S = Integer.toString(temp);
        	
        	count++;
        }
        
        System.out.println(count);
        
        if(S.equals("3") || S.equals("6") || S.equals("9")) {
        	
        	System.out.println("YES");
        } else {
        	
        	System.out.println("NO");
        }
    }
}