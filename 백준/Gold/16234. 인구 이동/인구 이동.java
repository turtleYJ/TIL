import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int[][] isVisit;
	private static int unionCount;
	private static int unionSum;
	private static int[] dy = {1, -1, 0, 0};
	private static int[] dx = {0, 0, 1, -1};
	private static int N;
	private static int[][] nations;
	private static int L;
	private static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		nations = new int[N][N];
		isVisit = new int[N][N];
		
		for (int i = 0; i < nations.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < nations[i].length; j++) {
				nations[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
		while (true) {
			// 연합을 dfs를 통해 한다.
			isVisit = new int[N][N];
			int unionNum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < nations.length; j++) {
					if(isVisit[i][j] == 0) {
						unionNum++;
						unionCount = 1;
						unionSum = nations[i][j];
						isVisit[i][j] = unionNum;
						List<int[]> unionList = new ArrayList<>();
						unionList.add(new int[] {i, j});
						
						union(i, j, unionNum, unionList);
						
						if (unionCount == 1) {
							unionNum--;
							isVisit[i][j] = 0;
						} else {
							int value = unionSum / unionCount;
							
							for (int k = 0; k < unionList.size(); k++) {
								int[] temp = unionList.get(k);
								nations[temp[0]][temp[1]] = value;
							}
						}
					}
				}
			}
			 
			if (unionNum == 0) {
				 
				break;
			}
			res++;
		}
		
		System.out.println(res);
	}

	private static void union(int y, int x, int unionNum, List<int[]> unionList) {
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
				int abs = Math.abs(nations[y][x] - nations[ny][nx]);
				if(isVisit[ny][nx] == 0 && abs >= L && abs <= R) {
					isVisit[ny][nx] = unionNum;
					unionCount++;
					unionSum += nations[ny][nx];
					unionList.add(new int[] {ny, nx});
					union(ny, nx, unionNum, unionList);
				}
			}
		}
	}
}