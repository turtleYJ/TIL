import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


	private static int M;
	private static int N;
	private static int[][] map;
	private static int[] dr = {1, -1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};
	private static Integer[][] dp;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = 0; // row
		N = 0; // column
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new Integer[M][N];
		
		for(int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[M - 1][N - 1] = 1;
		
		dfs(0, 0);
		
		System.out.println(dp[0][0]);
		
		
	}

	private static int dfs(int r, int c) {
		if(dp[r][c] != null) {
			
			return dp[r][c];
		}
			
		dp[r][c] = 0;
		for(int i = 0; i < 4; i ++) {
			
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			
			if(nextR >= 0 && nextC >= 0 && nextR < M && nextC < N) {
				
				if(map[nextR][nextC] < map[r][c]) {
					dp[r][c] += dfs(nextR, nextC);
				}
			}
		}
		
		return dp[r][c];
	}
}