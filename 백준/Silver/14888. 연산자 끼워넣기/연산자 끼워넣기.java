import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트래킹
public class Main {

	private static int N;
	private static int[] arr;
	private static int[] op;
	private static int maxSum = Integer.MIN_VALUE;
	private static int minSum = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 0;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		op = new int[4]; // + - * /
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			
			arr[i] =  Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 4; i++) {
			
			op[i] = Integer.parseInt(st.nextToken());
		}
		
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