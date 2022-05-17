import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 0;
		int Quarter = 25;
		int Dime = 10;
		int Nickel = 5;
		int Penny = 1;
		
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int changes = 0;
		int Q = 0;
		int D = 0;
		int N = 0;
		int P = 0;
		while(T-- > 0) {
			changes = Integer.parseInt(br.readLine());
			
			Q = changes / Quarter; 
			D = (changes % Quarter) / Dime;
			N = ((changes % Quarter) % Dime) / Nickel;
			P = (((changes % Quarter) % Dime) % Nickel) / Penny;
			
			sb.append(Q + " " + D + " " + N + " " + P).append('\n');
		}
		
		System.out.println(sb);
	}
}