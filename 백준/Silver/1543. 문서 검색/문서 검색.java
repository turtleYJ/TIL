import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = "";
		String targetS = "";
		
		S = br.readLine();
		targetS = br.readLine();
		
		int count = 0;
		
		for(int i = 0; i < S.length(); i++) {
			
			if(S.charAt(i) == targetS.charAt(0) && (S.length() - i) >= targetS.length()) {
				
				for(int j = 0; j < targetS.length(); j++) {
					if(S.charAt(j + i) != targetS.charAt(j)) {
						break;
					}
					
					if(j == targetS.length() -1) {
						count++;
						
						i += targetS.length() -1;						
					}
				}
				
			}
			
		}
		
		System.out.println(count);
	}
	
}