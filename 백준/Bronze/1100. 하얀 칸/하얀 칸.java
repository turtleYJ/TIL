import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int res = 0;
		for (int i = 0; i < 8; i++) {
			String S = br.readLine();
			for (int j = 0; j <8; j++) {
				char ch = S.charAt(j);
				
				if ((i + j) % 2 == 0 && ch == 'F') {
					res++;
				}
			}
		}
		System.out.println(res);
	}
}