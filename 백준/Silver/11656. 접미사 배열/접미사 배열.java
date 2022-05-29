import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        
        List<String> suffix = new ArrayList<>();
        
        for(int i = S.length() - 1 ; i >= 0; i--) {
        	
        	suffix.add(S.substring(i));
        }
        
        Collections.sort(suffix);
        
        for(int i = 0 ; i < suffix.size(); i++) {
        	
        	System.out.println(suffix.get(i));
        }
    }
}