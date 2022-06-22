import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class Main {

	private static int maxSum;
	private static int minSum;
	private static int N;
	private static int[] op;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		op = new int[4]; // 연산자의 개수를 넣어주는 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < op.length; i++) {
			op[i] =  Integer.parseInt(st.nextToken());
		}
		
		maxSum = Integer.MIN_VALUE;
		minSum = Integer.MAX_VALUE;
		operate(0, 0);
		
		System.out.println(maxSum);
		System.out.println(minSum);
		
		
	}
	
	private static void operate(int depth, int sum) {
		if(depth == N) {
			maxSum = Math.max(maxSum, sum);
			minSum = Math.min(minSum, sum);
			
			return;
		}
		
		if(depth == 0) {
			sum += arr[depth];
			operate(depth + 1, sum);
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] != 0) {
				
				int x = arr[depth];
				int nextSum = 0;
				op[i]--;
				
				switch (i) {
				case 0:
					nextSum = sum + x;
					break;
				case 1:
					nextSum = sum - x;
					break;
				case 2:
					nextSum = sum * x;
					break;
				case 3:
					nextSum = sum / x;
					break;
				}
				
				operate(depth + 1, nextSum);
				op[i]++;
			}
		}
	}
}