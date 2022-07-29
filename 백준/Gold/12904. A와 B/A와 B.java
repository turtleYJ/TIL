import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();
		
		while (T.length() > S.length()) {
			if (T.charAt(T.length() - 1) == 'A') {
				T = T.substring(0, T.length() - 1);
			} else {
				T = T.substring(0, T.length() - 1);
				StringBuilder sb = new StringBuilder(T);
				T = "" + sb.reverse();
			}
		}
		
		if (T.equals(S)) System.out.println(1);
		else System.out.println(0);
	}
}