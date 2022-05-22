import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	private static int N;
	private static int[][] area;
	private static boolean[][] isVisit;
	private static int[] dr = {1, -1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N  = 0;
		
		N = Integer.parseInt(br.readLine());
		
		area = new int[N][N];
		
		int max = 0;
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int x = Integer.parseInt(st.nextToken());
				
				area[i][j] = x;
				
				max = Math.max(max, x);
			}
		}
		
		isVisit = new boolean[N][N];
		int count = 0;
		int countMax = 0;
		for(int k = 0; k <= max; k++) {
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(area[i][j] > k && !isVisit[i][j]) {
						dfs(i, j, k);
						
						count++;
					}
				}
			}
			
			countMax = Math.max(countMax, count);
			isVisit = new boolean[N][N];
			count = 0;
		}
		
		System.out.println(countMax);
	}

	private static void dfs(int r, int c, int height) {
		isVisit[r][c] = true;
		
		for(int i = 0 ; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			
			if(nextR >= 0 && nextC >= 0 && nextR < N && nextC < N) {
				if(area[nextR][nextC] > height && !isVisit[nextR][nextC]) {
					dfs(nextR, nextC, height);
				}
			}
		}
	}
}