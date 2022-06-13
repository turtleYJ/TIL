import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기 3
// 밤 낮 추가
public class Main {
	static class Place {
		int y;
		int x;
		int dis;
		int drill;
		int dayOrNight;
		
		
		public Place(int y, int x, int dis, int drill, int dayOrNight) {
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.drill = drill;
			this.dayOrNight = dayOrNight % 2;
		}
	}
	
	private static int N;
	private static int M;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	private static int[][] matrix;
	private static int res;
	private static int K;
	private static boolean[][][] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		isVisit = new boolean[N][M][K + 1];
		String S = "";
		
		
		for (int i = 0; i < matrix.length; i++) {
			S = br.readLine(); 
			for (int j = 0; j < matrix[i].length; j++) {
				int n = S.charAt(j) - 48;
				matrix[i][j] = n;
			}
		}
		
		res = Integer.MAX_VALUE;
		bfs(0, 0);
		
		if (res == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(res);
		
		
	}

	private static void bfs(int y, int x) {
		Queue<Place> q = new LinkedList<>();
		q.add(new Place(y, x, 1, 0, 0)); 
		isVisit[y][x][0] = true;
		
		while(!q.isEmpty()) {
			Place temp = q.poll();
			
			if(temp.y == N - 1 && temp.x == M - 1) {
				res = temp.dis;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = temp.y + dy[i];
				int nx = temp.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				
				// 벽이 아닌 경우
				if(matrix[ny][nx] == 0 && !isVisit[ny][nx][temp.drill]) {
					isVisit[ny][nx][temp.drill] = true;
					q.add(new Place(ny, nx, temp.dis + 1, temp.drill, temp.dayOrNight + 1));
				}
				
				// 벽인 경우
				else {
					if(temp.drill < K && !isVisit[ny][nx][temp.drill]) {
						if(temp.dayOrNight == 0) {
							isVisit[ny][nx][temp.drill] = true;
							q.add(new Place(ny, nx, temp.dis + 1, temp.drill + 1, temp.dayOrNight + 1));
						} else {
							q.add(new Place(temp.y, temp.x, temp.dis + 1, temp.drill, temp.dayOrNight + 1));
						}
					}
				}
			}
		}
	}
}