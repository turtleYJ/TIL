import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 0;
		int K = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		for(int i = 1; i <= N; i++) {
			
			if(N % i == 0) {
				
				count++;
			}
			
			if(count == K) {
				
				System.out.println(i);
				
				return;
			}
		}
		
		System.out.println(0);
	}
}