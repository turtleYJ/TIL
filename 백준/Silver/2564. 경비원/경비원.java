import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()); // 상점의 갯수
		int[] stores = new int[K];
		
		//1 - 북쪽, 2 - 남쪽, 3 - 서쪽, 4 - 동쪽
		int security = 0;
		for (int i = 0; i < stores.length + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			int abLen = 0;
			
			switch (dir) {
			case 1:
				abLen = 2 * N + M + (M - len);
				
				break;
			case 2:
				abLen = N + len;
				
				break;
			case 3:
				abLen = len;
				
				break;
			case 4:
				abLen = N + M + (N - len);
				
				break;
			}
			
			if (i < stores.length) {
				stores[i] = abLen;
			} else {
				security = abLen;
			}
		}
		
		int totalLen = 2 * N + 2 * M;
		int res = 0;
		for (int i : stores) {
			int n1 = Math.abs(i - security);
			int n2 = 0;
			
			if (i > security) {
				n2 = totalLen - i + security;
			} else {
				n2 = totalLen - security + i;
			}
			
			res += Math.min(n1, n2);
		}
		
		System.out.println(res);
	}
}