import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = "";
		int M = 0;
		
		S = br.readLine();
		
		for(int i = 0; i < S.length(); i++) {
			
			System.out.print(S.charAt(i));
			
			if(i % 10 == 9) {
				System.out.println();
			}
		}
	}
}