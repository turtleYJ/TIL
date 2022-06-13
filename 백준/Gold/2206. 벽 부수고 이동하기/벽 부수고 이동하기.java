import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	private static int[][] matrix;
	private static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		String S = "";
		
		
		for (int i = 0; i < matrix.length; i++) {
			S = br.readLine(); 
			for (int j = 0; j < matrix[i].length; j++) {
				int n = S.charAt(j) - 48;
				matrix[i][j] = n;
			}
		}
		
		boolean[][][] isVisit = new boolean[N][M][2];  // 0 은 안 부신 경우, 1은 부신 경우
		res = Integer.MAX_VALUE;
		bfs(0, 0, isVisit);
		
		if (res == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(res + 1);
		}
		
		
	}

	private static void bfs(int x, int y, boolean[][][] isVisit) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y, 0, 0}); // 순서대로 x, y, 부셨는지?, 거리
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			int isCrash = temp[2];
			int dis = temp[3];
			
			if(r == N - 1 && c == M - 1) {
				res = temp[3];
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int newR = r + dr[i];
				int newC = c + dc[i];
				
				if (newR >= 0 && newC >= 0 && newR < N && newC < M) {
					// 이전에 벽을 부수지 않은 경우면서 방문하지 않은 곳인 경우
					if(isCrash == 0 && !isVisit[newR][newC][0]) {
						// 벽일 때
						if(matrix[newR][newC] == 1) {
							q.add(new int[] {newR, newC, isCrash + 1, dis + 1});
							// 한 번 부순 경우 다시 못 부수게 하는 역할
							isVisit[newR][newC][1] = true;
						}
						// 벽이 아닐 떄
						else {
							q.add(new int[] {newR, newC, isCrash, dis + 1});
							isVisit[newR][newC][0] = true;
						}
					}
					// 이전에 벽을 부순 경우면서 방문하지 않은 곳인 경우
					// 벽을 부신 상태(isCrash == 1)에서 isVisit의 두상태 모두를 제외할 수 있는 이유는 bfs는 레벨에 따라 움직이는데, 안 부신 상태의 빠른 것이 부신상태의 빠른 것 보다 월등하기에 대체가능하기 때문이다.
					if(isCrash == 1 && !isVisit[newR][newC][1] && !isVisit[newR][newC][0]) {
						if(matrix[newR][newC] == 0) { // 벽이 아닐 때만 큐에 넣어준다.
							q.add(new int[] {newR, newC, isCrash, dis + 1});
							isVisit[newR][newC][1] = true;
						}
					}
				}
			}
		}
	}
}