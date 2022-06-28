import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = arr.length - 1;
		int min = Integer.MAX_VALUE;
		int val1 = 0;
		int val2 = 0;
		
		while (start < end) {
			int sum = arr[start] + arr[end];
			int abs = Math.abs(sum);
			
			if (sum == 0) {
				val1 = arr[start];
				val2 = arr[end];
				break;
			}
			
			if (abs < min) {
				val1 = arr[start];
				val2 = arr[end];
				min = abs;
			}
			
			if (sum > 0) {
				end--;
			}
			if (sum < 0) {
				start++;
			}
		}
		
		System.out.println(val1 + " " + val2);
	}
}