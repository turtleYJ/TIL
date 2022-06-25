import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int res = Integer.MIN_VALUE;
		while(start < N) {
			int diff = end - start;
			if (diff == K || end == N) {
				if(diff == K) res = Math.max(res, sum);
				sum -= arr[start];
				start++;
			}
			else {
				sum += arr[end];
				end++;
			}
			
			diff = end - start;
		}
		
		System.out.println(res);
		
		
	}
}