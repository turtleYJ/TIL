import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        
        int length = S.length();
        
        int[] alphabet = new int[26];
        int[] result = new int[length];
        
        for(int i = 0; i < length; i++) {
        	alphabet[S.charAt(i) - 65]++;
        }
        
        int T = length / 2 + 1;
        int k = 0;
        
        while(T-- > 0) {
        	
        	
        	for(int i = 0; i < alphabet.length; i++) {
        		if(alphabet[i] > 1) {
        			result[k] = i + 65;
            		result[(length - 1) - k] = i + 65;
            		alphabet[i] -= 2;
            		k++;
            		
            		break;
        		}
        	}
        	
        	for(int i = 0; i < alphabet.length; i++) {
        		if(alphabet[i] % 2 == 1) {
            		result[length / 2] = i + 65;
            	}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i : result) {
        	if(i == 0) {
        		System.out.println("I'm Sorry Hansoo");
        		
        		return;
        	}
			sb.append((char)i);
		}
        
        System.out.println(sb);
    }
}