import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();
		int F = Integer.parseInt(br.readLine());
		
		String edge = "";
		String temp = "";
		for (int i = 0; i < 99; i++) {
			int num = i;
			
			if (num < 10) {
				edge = "0" + num;
			} else {
				edge = "" + num;
			}
			
			temp = N.substring(0, N.length() - 2) + edge;
			
			if (Integer.valueOf(temp) % F == 0) {
				System.out.println(edge);
				return;
			}
		}
	}
}