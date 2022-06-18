import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int max;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		boolean[] isVisit = new boolean[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		String combo = "";
		findMax(arr, 0, combo, isVisit);
		
		System.out.println(max);
	}

	private static void findMax(int[] arr, int depth, String combo, boolean[] isVisit) {
		if(depth == N) {
			cal(combo, arr);
			return;
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			if(!isVisit[i]) {
				isVisit[i] = true;
				String S = combo + arr[i] + " ";
				findMax(arr, depth + 1, S, isVisit);
				isVisit[i] = false;
			}
		}
	}

	private static void cal(String combo, int[] arr) {
		StringTokenizer st = new StringTokenizer(combo);
		int sum = 0;

		int bf = Integer.parseInt(st.nextToken());
		while (st.hasMoreTokens()) {
			int cur = Integer.parseInt(st.nextToken());
			sum += Math.abs(bf - cur);
			bf = cur;
		}
		
		max = Math.max(max, sum);
	}
}