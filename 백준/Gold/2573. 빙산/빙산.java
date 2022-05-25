import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int[][] icebug;
	private static int[][] melt;
	private static boolean[][] isVisit;
	private static int[] dr = {1, -1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 0; // row
		M = 0; // column
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		icebug = new int[N][M];
		melt= new int[N][M];
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				icebug[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		
		while(true) {
			int count = 0;
			
			isVisit = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!isVisit[i][j] && icebug[i][j] != 0) {
						dfs(i, j);
						
						count++;
					}
				}
			}
			
			if(count > 1) break;
			if(count == 0) {
				System.out.println("0");
				
				return;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					icebug[i][j] -= melt[i][j];
					
					if(icebug[i][j] < 0) {
						
						icebug[i][j] = 0;
					}
				}
			}
			
			melt= new int[N][M];
			
			year++;
		}
		
		System.out.println(year);
	}

	private static void dfs(int r, int c) {
		isVisit[r][c] = true;
		int nextR = 0;
		int nextC = 0;
		
		for(int i = 0; i < 4; i++) {
			
			nextR = r + dr[i];
			nextC = c + dc[i];
			
			if(nextR >= 0 && nextC >= 0 && nextR < N && nextC < M) {
				
				if(icebug[nextR][nextC] == 0) {
					melt[r][c]++;
				}
				
				if(!isVisit[nextR][nextC] && icebug[nextR][nextC] != 0) {
					
					dfs(nextR, nextC);
				}
			}
		}
		
	}
}