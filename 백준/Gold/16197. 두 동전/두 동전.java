import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static List<int[]> startList;
	private static int[] dy = {1, -1, 0, 0};
	private static int[] dx = {0, 0, 1, -1};
	private static int N;
	private static int M;
	private static int res;
	private static boolean[][][][] isVisit;
	private static char[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		startList = new ArrayList<>();
		
		String S = "";
		for (int i = 0; i < board.length; i++) {
			S = br.readLine();
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = S.charAt(j);
				if (board[i][j] == 'o') {
					startList.add(new int[] {i, j});
				}
			}
		}
		
		isVisit = new boolean[N][M][N][M];
		res = Integer.MAX_VALUE;
		dropAnother();
		
		if(res == Integer.MAX_VALUE) {
			res = -1;
		}
		
		System.out.println(res);
		
	}

	private static void dropAnother() {
		Queue<TwoCoin> q = new LinkedList<>();
		
		int y1 = startList.get(0)[0];
		int x1 = startList.get(0)[1];
		int y2 = startList.get(1)[0];
		int x2 = startList.get(1)[1];
		
		isVisit[y1][x1][y2][x2] = true;
		q.add(new TwoCoin(y1, x1, y2, x2, 0));
		
		while(!q.isEmpty()) {
			TwoCoin tc = q.poll();
			
			if(tc.count >= 10) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny1 = tc.y1 + dy[i];
				int nx1 = tc.x1 + dx[i];
				int ny2 = tc.y2 + dy[i];
				int nx2 = tc.x2 + dx[i];
				
				// 가야할 방향이 벽이면 그대로 멈춘다.
				if (isWall(ny1, nx1)) {
					ny1 = tc.y1;
					nx1 = tc.x1;
				}
				if (isWall(ny2, nx2)) {
					ny2 = tc.y2;
					nx2 = tc.x2;
				}
				
				int stay = 0;
				
				if (ny1 >= 0 && nx1 >= 0 && ny1 < N && nx1 < M) stay++;
				if (ny2 >= 0 && nx2 >= 0 && ny2 < N && nx2 < M) stay++;
				
				if (stay == 0) continue;
				
				if (stay == 1) {
					res = tc.count + 1;
					return;
				}
				
				if (stay == 2 && !isVisit[ny1][nx1][ny2][nx2]) {
					q.add(new TwoCoin(ny1, nx1, ny2, nx2, tc.count + 1));
				}
				
			}
		}
	}

	private static boolean isWall(int ny, int nx) {
		boolean res = false;
		
		if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
			if(board[ny][nx] == '#') res = true;
		}
		
		
		return res;
	}
}

class TwoCoin {
	int y1;
	int x1;
	int y2;
	int x2;
	int count;
	
	public TwoCoin(int y1, int x1, int y2, int x2, int count) {
		this.y1 = y1;
		this.x1 = x1;
		this.y2 = y2;
		this.x2 = x2;
		this.count = count;
	}
}