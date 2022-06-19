import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int start = 0;
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = n;
			end = Math.max(end, arr[i]);
		}
		
		// 이분 탐색
		while (start <= end) {
			int mid = (start + end) / 2;
			
			// 1 - up, 0 - correct, -1 - down
			long sum = calculateLength(mid);
			
			if (sum >= M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}

	private static long calculateLength(int mid) {
		long sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int diff = arr[i] - mid;
			if (diff > 0) sum += diff;
		}
		return sum;
	}
}
