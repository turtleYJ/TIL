import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 0;
		
		N = Integer.parseInt(br.readLine());
		
		int[] level = new int[N];
		
		for(int i = 0; i < N; i++) {
			level[i] = Integer.parseInt(br.readLine());
		}
		
		int temp = level[N - 1];
		int count = 0;
		for(int i = N - 2; i >= 0; i--) {
			if(level[i] >= temp) {
				temp = temp - 1;
				count += level[i] - temp;
			} else {
				temp = level[i];
			}
		}
		
		System.out.println(count);
	}
}