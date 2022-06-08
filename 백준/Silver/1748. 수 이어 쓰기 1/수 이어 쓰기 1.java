import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		int digit = 1;
		int bound = 10;
		
		for (int i = 1; i <= N; i++) {
			if(i == bound) {
				digit += 1;
				bound *= 10;
			}
			result += digit;
		}
		
		System.out.println(result);
	}
}