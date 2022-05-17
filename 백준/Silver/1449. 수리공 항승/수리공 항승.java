import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 0;
		int L = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		L = Integer.parseInt(st.nextToken());
		
		int[] pipe = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pipe[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(pipe);
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - i; j++) {
				if(i < N - 1) {
					if((pipe[i + j] - pipe[i] + 1) > L) {
						count++;
						
						i += j - 1;
						
						break;
					}
				}
			}
 		}
		
		System.out.println(count + 1);
	}
}