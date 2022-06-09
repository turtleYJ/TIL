import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 마인크래프트
// 땅을 파는데 2초, 올리는데 1초
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(arr[i][j], min);
				max = Math.max(arr[i][j], max);
			}
		}
		
		int minCost = Integer.MAX_VALUE;
		int minHeight = 0;
		
		for (int i = max; i >= min; i--) {
//			minCost = Math.min(minCost, findCost(arr, i, B));
			int temp = findCost(arr, i, B);
			if(temp < minCost) {
				minCost = temp;
				minHeight = i;
			}
		}
		
		System.out.println(minCost + " " + minHeight);
		
		
	}

	private static int findCost(int[][] arr, int target, int inventory) {
		int cost = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int gap = target - arr[i][j];
				if(gap < 0) {
					cost += ((-gap) * 2);
					inventory += -gap;
				} else if(gap > 0) {
					cost += gap;
					inventory -= gap;
				}
			}
		}
		if(inventory < 0) return Integer.MAX_VALUE;
		
		return cost;
	}
}