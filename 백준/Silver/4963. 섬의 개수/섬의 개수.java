import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	private static int w;
	private static int h;
	private static boolean[][] isVisit;
	private static int[] dh = {1, 0, -1, 1, -1, 1, 0, -1};
	private static int[] dw = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		w = 0; 
		h = 0; 
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			
			for(int i = 0 ; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			isVisit = new boolean[h][w];
			int count = 0;
			
			for(int i = 0 ; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !isVisit[i][j]) {
						dfs(i, j);
						
						count ++;
					}
				}
			}
			
			sb.append(count).append('\n');
		}
		
		System.out.println(sb);
		
	}

	private static void dfs(int r, int c) {
		isVisit[r][c] = true;
		
		for(int i = 0; i < 8; i++) {
			int nextR = r + dh[i];
			int nextC = c + dw[i];
			
			if(nextR >= 0 && nextC >= 0 && nextR < h && nextC < w) {
				if(!isVisit[nextR][nextC] && map[nextR][nextC] == 1) {
					dfs(nextR, nextC);
				}
			}
		}
	}

}