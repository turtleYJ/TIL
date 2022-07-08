import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			String S = br.readLine();
			
			char f = S.charAt(0);
			char b = S.charAt(S.length() - 1);
			
			System.out.println("" + f + b);
		}
		
		
	}
}