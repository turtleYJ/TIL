import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트래킹
// 6603
// 조합
public class Main {

	private static int k;
	private static boolean[] isVisit;
	private static int[] arr;
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			
			k = 0;
			k = Integer.parseInt(st.nextToken());
			
			if (k == 0) break;
			
			arr = new int[k];
			
			for(int i = 0; i < k; i++) {
				
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			isVisit = new boolean[k];
			
			backTracking(0, 0);
			
			System.out.println();
		}
		
	}

	private static void backTracking(int idx, int depth) {
		
		if(depth == 6) {
			
			printNumber();
			
			return;
		}
		
		for(int i = idx; i < k; i++) {
				
				isVisit[i] = true;
				backTracking(i + 1, depth + 1);
				isVisit[i] = false;
		}
	}

	private static void printNumber() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < k; i++) {
			
			if(isVisit[i]) {
				sb.append(arr[i]).append(" ");
			}
		}
		
		System.out.println(sb);
	}
}