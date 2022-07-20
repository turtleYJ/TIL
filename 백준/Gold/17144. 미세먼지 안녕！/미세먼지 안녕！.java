import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] dr = {1, -1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};
	private static int C;
	private static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		List<int[]> airCleanerPosition = new ArrayList<>();
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == -1) {
					airCleanerPosition.add(new int[] {i, j});
				}
			}
		}
		
		
		while(T-- > 0) {
			int[][] tempMap = new int[R][C];
			tempMap[airCleanerPosition.get(0)[0]][airCleanerPosition.get(0)[1]] = -1;
			tempMap[airCleanerPosition.get(1)[0]][airCleanerPosition.get(1)[1]] = -1;
			
			// 퍼뜨리
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					int n = map[i][j];
					
					// 퍼트린다.
					if (n > 0) {
						int cnt = 0;
						
						for (int k = 0; k < 4; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							
							if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] != -1) {
								cnt++;
								tempMap[nr][nc] += map[i][j] / 5;
							}
						}
						tempMap[i][j] += map[i][j] - (map[i][j] / 5 * cnt);
					}
				}
			}
			
			// 공기청정
			windUpper(tempMap, airCleanerPosition.get(0)[0], airCleanerPosition.get(0)[1]);
			windlower(tempMap, airCleanerPosition.get(1)[0], airCleanerPosition.get(1)[1]);
			
			map = tempMap;
			
			
		}
		
		int res = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] > 0) {
					res += map[i][j];
				}
			}
		}
		
		System.out.println(res);
		
	}
	
	private static void windlower(int[][] tempMap, int r, int c) {
		int rLimit = r;
		r++;
		
		while (r + 1 < R) {
			tempMap[r][c] = tempMap[r + 1][c];
			r++;
		}
		
		while (c + 1 < C) {
			tempMap[r][c] = tempMap[r][c + 1];
			c++;
		}
		
		while (r > rLimit) {
			tempMap[r][c] = tempMap[r - 1][c];
			r--;
		}
		
		
		while (c > 1) {
			tempMap[r][c] = tempMap[r][c - 1];
			c--;
		}
		tempMap[r][c] = 0;
	}
		
	private static void windUpper(int[][] tempMap, int r, int c) {
		int rLimit = r;
		r--;
		
		while (r > 0) {
			tempMap[r][c] = tempMap[r - 1][c];
			r--;
		}
		
		while (c + 1 < C) {
			tempMap[r][c] = tempMap[r][c + 1];
			c++;
		}
		
		while (r < rLimit) {
			tempMap[r][c] = tempMap[r + 1][c];
			r++;
		}
		
		while (c > 1) {
			tempMap[r][c] = tempMap[r][c - 1];
			c--;
		}
		tempMap[r][c] = 0;
	}
}

	
