import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 0;
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			min = Math.min(min, arr[i]);
		}
		
		for(int i = 1; i <= min; i++) {
			
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] % i != 0) break;
				
				if(j == arr.length - 1) {
					
					System.out.println(i);
				}
			}
		}
	}
}