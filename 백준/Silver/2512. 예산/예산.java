import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int left = 0;
		int right = -1;
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		while(left <= right) {
			int mid = (left + right) / 2;
			long budget = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] > mid) budget += mid;
				else budget += arr[i];
			}
			// 예산을 다 더했을 때 총 예산(M) 보다 작거나 같으면 더 큰 mid값으로 탐색해보기 위해 left값을 +1 해준다.
			if (budget <= M) left = mid + 1;
			else right = mid - 1;
		}
		
		
		System.out.println(right);
	}
}
