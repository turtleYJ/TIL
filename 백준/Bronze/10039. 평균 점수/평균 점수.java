import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int memNum = 5;
		int sum = 0;
		while(memNum-- > 0) {
			int score = Integer.parseInt(br.readLine());
			if (score < 40) score = 40;
			
			sum += score;
			
		}
		System.out.println(sum / 5);
	}
}