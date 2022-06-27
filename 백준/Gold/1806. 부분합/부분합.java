import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		long sum = 0;
		int count = 0;
		int res = Integer.MAX_VALUE;
		while (start < arr.length) {
			if (sum >= M || end == N) {
				if (sum >= M) {
					res = Math.min(res, count);
				}
				sum -= arr[start];
				start++;
				count--;
			}
			else {
				sum += arr[end];
				end++;
				count++;
			}
		}
		
		if (res != Integer.MAX_VALUE) System.out.println(res);
		else System.out.println(0);
	}
}