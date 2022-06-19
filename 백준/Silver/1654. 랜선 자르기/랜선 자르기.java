import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[K];
		
		long start = 1;
		long end = 0;
		for (int i = 0; i < arr.length; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i] = n;
			end = Math.max(end, arr[i]);
		}
		
		// 이분 탐색
		while (start <= end) {
			long mid = (start + end) / 2;
			
			long sum = calculate(mid);
			
			if (sum >= N) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}

	private static long calculate(long mid) {
		long sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] / mid;
		}
		return sum;
	}
}