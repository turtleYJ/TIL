import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Integer[] A = new Integer[N];
			Integer[] B = new Integer[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < A.length; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < B.length; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A, Collections.reverseOrder());
			Arrays.sort(B, Collections.reverseOrder());
			
			int i = 0;
			int j = 0;
			int jNum = B.length;
			int sum = 0;
			while (i < N && j < M) {
				if (A[i] > B[j]) {
					sum += jNum;
					i++;
				} else {
					j++;
					jNum--;
				}
			}
			System.out.println(sum);
		}
	}
}