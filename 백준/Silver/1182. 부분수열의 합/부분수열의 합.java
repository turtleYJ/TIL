import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int res;
	private static int S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		res = 0;
		
		for (int i = 0; i < arr.length; i++) {
			bt(arr, 0, 0, i + 1);
		}
		
//		bt(arr, 0, 0, 1);
		
		System.out.println(res);
		
		
	}

	private static void bt(int[] arr, int sum, int idx, int depth) {
		
		if(depth == 0) {
//			System.out.println(sum);
			if (sum == S) res++;
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sum += arr[i];
			
			bt(arr, sum, i + 1, depth - 1);
			sum -= arr[i];
		}
	}
}