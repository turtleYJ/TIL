import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] isVisit;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 0;
		M = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // row
		M = Integer.parseInt(st.nextToken()); // column
		
		map = new int[N][M];
		isVisit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String S = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = S.charAt(j) - 48;
			}
		}
		
		isVisit[0][0] = true;
 		bfs(0, 0);
 		
 		System.out.println(map[N - 1][M - 1]);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int i = 0; i < 4; i++) {
				int newR = r + dr[i];
				int newC = c + dc[i];
				
				// 조건
				// newR, newC모두 0 보다 커야하며 각각 N보다 작고, M보다 작아야한다.
				if(newR >= 0 && newC >= 0 && newR < N && newC < M) {
					if(!isVisit[newR][newC] && map[newR][newC] == 1) {
						q.add(new int[] {newR, newC});
						
						isVisit[newR][newC] = true;
						map[newR][newC] = map[r][c] + 1;
					}
				}
			}
		}
	}
}