import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] dy = {1, -1, 0, 0};
	private static int[] dx = {0, 0, 1, -1};
	private static int res;
	private static int n;
	private static int[][] forest;
	private static Integer[][] DP;
	private static int cur;
	private static int localMax;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		forest = new int[n][n];
		
		for (int i = 0; i < forest.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < forest.length; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
		DP = new Integer[n][n];
		for (int i = 0; i < forest.length; i++) {
			for (int j = 0; j < forest.length; j++) {
				if(DP[i][j] == null) {
					cur = 0;
					localMax = 0;
					dfs(i, j, 1);
					res = Math.max(cur, res);
				}
			}
		}
		System.out.println(res);
	}

	private static void dfs(int y, int x, int cnt) {
		cur = Math.max(cur, cnt);
		
		boolean pass = true;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >= 0 && nx >= 0 && ny < n && nx < n) {
				
				if (forest[ny][nx] > forest[y][x]) {
					pass = false;
					
					if (DP[ny][nx] != null) {
						cur = Math.max(cur, cnt + DP[ny][nx]);
						if(DP[y][x] == null) {
							DP[y][x] = DP[ny][nx] + 1;
						} else {
							DP[y][x] = Math.max(DP[y][x], DP[ny][nx] + 1);
						}
						
						continue;
					} else {
						dfs(ny, nx, cnt + 1);
						if(DP[y][x] == null) {
							DP[y][x] = DP[ny][nx] + 1;
						} else {
							DP[y][x] = Math.max(DP[y][x], DP[ny][nx] + 1);
						}
					}
				}
			}
		}
		if(pass) {
			localMax = cnt;
			DP[y][x] = localMax - cnt + 1;
		}
	}
}