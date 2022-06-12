import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String nS = "";
		
		for (int i = 0; i < S.length(); i++) {
			int c = S.charAt(i);
			if(c >= 65 && c <= 90) {
				nS += "" + (char)(c + 32);
			}
			if(c >= 97 && c <= 122) {
				nS += "" + (char)(c - 32);
			}
		}
		System.out.println(nS);
	}
}