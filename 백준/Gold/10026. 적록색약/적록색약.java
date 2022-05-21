import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	private static int N;
	private static boolean[][] isVisit;
	private static boolean[][] isVisitRG;
	private static int[] dr = {1, -1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};
	private static char[][] area;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 0; 
		
		N = Integer.parseInt(br.readLine());
		
		area = new char[N][N];
		
		String S = "";
		for(int i = 0 ; i < N; i++) {
			S = br.readLine();
			for(int j = 0; j < N; j++) {
				area[i][j] = S.charAt(j);
			}
		}
		
		isVisit = new boolean[N][N];
		isVisitRG = new boolean[N][N];
		int countR = 0;
		int countG = 0;
		int countB = 0;
		int countRG = 0;
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if((area[i][j] == 'R' || area[i][j] == 'G') && !isVisitRG[i][j]) {
					dfsRG(i, j);
					
					countRG++;
				}
				
				if(area[i][j] == 'R' && !isVisit[i][j]) {
					dfs(i, j, 'R');
					
					countR++;
				}
				
				if(area[i][j] == 'G' && !isVisit[i][j]) {
					dfs(i, j, 'G');
					
					countG++;
				}
				
				if(area[i][j] == 'B' && !isVisit[i][j]) {
					dfs(i, j, 'B');
					
					countB++;
				}
			}
		}
		
		System.out.println(countR + countG + countB + " " + (countRG + countB));
		
	}

	private static void dfsRG(int r, int c) {
		isVisitRG[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			
			if(nextR >= 0 && nextC >= 0 && nextR < N && nextC < N) {
				if(!isVisitRG[nextR][nextC] && (area[nextR][nextC] == 'R' || area[nextR][nextC] == 'G')) {
					dfsRG(nextR, nextC);
				}
			}
		}
	}

	private static void dfs(int r, int c, char color) {
		isVisit[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			
			if(nextR >= 0 && nextC >= 0 && nextR < N && nextC < N) {
				if(!isVisit[nextR][nextC] && area[nextR][nextC] == color) {
					dfs(nextR, nextC, color);
				}
			}
		}
	}

}