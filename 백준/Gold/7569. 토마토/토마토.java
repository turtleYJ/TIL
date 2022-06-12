import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] dh = {1, -1, 0, 0, 0, 0};
	private static int[] dr = {0, 0, 1, -1, 0, 0};
	private static int[] dc = {0, 0, 0, 0, 1, -1};
	private static int M;
	private static int N;
	private static int H;
	private static int[][][] boxes;
	private static int day;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		H = Integer.parseInt(st.nextToken()); // 높이
		
		boxes = new int[H][N][M];
		List<int[]> ripeT = new ArrayList<>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					boxes[i][j][k] = Integer.parseInt(st.nextToken());
					
					if(boxes[i][j][k] == 1) {
						ripeT.add(new int[] {i, j, k});
					}
				}
			}
		}
		boolean[][][] isVisit = new boolean[H][N][M];
		day = 0;
		bfs(ripeT, isVisit);
		
		for (int[][] is : boxes) {
			for (int[] i : is) {
				for (int v : i) {
					if(v == 0) {
						System.out.println(-1);
						
						return;
					}
				}
			}
		}
		
		System.out.println(day);
	}

	private static void bfs(List<int[]> ripeT, boolean[][][] isVisit) {
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < ripeT.size(); i++) {
			q.offer(ripeT.get(i));
		}
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int h = temp[0];
			int r = temp[1];
			int c = temp[2];
			
			for (int i = 0; i < 6; i++) {
				int nextH = h + dh[i]; 
				int nextR = r + dr[i];
				int nextC = c + dc[i];
				
				if(nextR >= 0 && nextC >= 0 && nextH >= 0 && nextR < N && nextC < M && nextH < H) {
					if(!isVisit[nextH][nextR][nextC] && boxes[nextH][nextR][nextC] == 0) {
						q.add(new int[] {nextH, nextR, nextC});
						isVisit[nextH][nextR][nextC] = true;
						boxes[nextH][nextR][nextC] = boxes[h][r][c] + 1;
						
						day = Math.max(day, boxes[nextH][nextR][nextC] - 1);
					}
				}
			}
		}
	}
}