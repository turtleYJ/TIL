import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static boolean[] isVisit;
	private static int[] arr;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 0;
		M = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isVisit = new boolean[N + 1];
		arr = new int[M]; // 1, 2, 3, 4,
		
		sb = new StringBuilder();
		
		dfs(1, 0);
		
		System.out.println(sb);
	}

	private static void dfs(int numAt, int depth) {
		
		if(depth == M) {
			
			for(int i = 0; i < arr.length; i++) {
				
				sb.append(arr[i] + " ");
			}
			
			sb.append('\n');
			
			return;
		}
		
		for(int i = numAt; i <= N; i++) {
			
				arr[depth] = i;
				dfs(i, depth + 1);
		}
	}
}