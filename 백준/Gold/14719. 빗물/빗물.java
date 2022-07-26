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
		int[] indexs = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < indexs.length; i++) {
			indexs[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		for (int i = 1; i < M - 1; i++) {
			int leftMax = Integer.MIN_VALUE;
			int rightMax = Integer.MIN_VALUE;
			int num = indexs[i];
			
			for (int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, indexs[j]);
			}
			for (int j = i + 1; j < indexs.length; j++) {
				rightMax = Math.max(rightMax, indexs[j]);
			}
			
			int small = Math.min(rightMax, leftMax);
			if(small - num > 0) {
				res += (small - num);
			}
		}
		
		System.out.println(res);
	}
}
