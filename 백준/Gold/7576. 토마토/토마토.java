import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static int[][] box;
	private static boolean[][] isVisit;
	private static int day = 0;
	private static int[] dr = {1, -1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = 0;
		N = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // column
		N = Integer.parseInt(st.nextToken()); // row
		
		box = new int[N][M];
		isVisit = new boolean[N][M];
		List<int[]> ripeT = new ArrayList<>();
		
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				int x = Integer.parseInt(st.nextToken());;
				
				box[i][j] = x;
				
				if(x == 1) {
					ripeT.add(new int[] {i, j});
					
					isVisit[i][j] = true;
				}
			}
		}
		
		bfs(ripeT);
		
		for (int[] is : box) {
			for (int i : is) {
				if(i == 0) {
					System.out.println(-1);
					
					return;
				}
			}
		}
		
		System.out.println(day);
	}

	private static void bfs(List<int[]> ripeT) {
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < ripeT.size(); i++) {
			q.add(ripeT.get(i));
		}
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			
			for(int i = 0; i < 4; i++) {
				int nextR = r + dr[i];
				int nextC = c + dc[i];
				
				if(nextR >= 0 && nextC >= 0 && nextR < N && nextC < M) {
					if(!isVisit[nextR][nextC] && box[nextR][nextC] == 0) {
						q.add(new int[] {nextR, nextC});
						
						isVisit[nextR][nextC] = true;
						box[nextR][nextC] = box[r][c] + 1;
						
						day = Math.max(day, box[nextR][nextC] - 1);
					}
				}
			}
		}
	}
}