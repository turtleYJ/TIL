import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int N;
	private static boolean[][] tempPosition;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<int[]> cloudList = new ArrayList<>();
		cloudList.add(new int[] {N - 1, 0});
		cloudList.add(new int[] {N - 1, 1});
		cloudList.add(new int[] {N - 2, 0});
		cloudList.add(new int[] {N - 2, 1});
		
		while (M-- > 0) {
			tempPosition = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			move(cloudList, d, s);
			
			rain(map, cloudList);
			
			duplicateWater(map, cloudList);
			
			generateCld(map, cloudList);
		}
		
		int res = 0;
		for (int[] is : map) {
			for (int waterAmount : is) {
				res += waterAmount;
			}
		}
		
		System.out.println(res);
	}

	private static List<int[]> generateCld(int[][] map, List<int[]> cloudList) {
		
		cloudList.clear();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (!tempPosition[i][j]) {
					if (map[i][j] >= 2) {
						map[i][j] -= 2;
						cloudList.add(new int[] {i, j});
					}
				}
			}
		}
		
		return null;
	}

	private static void duplicateWater(int[][] map, List<int[]> cloudList) {
		
		for (int[] cloud : cloudList) {
			int y = cloud[0];
			int x = cloud[1];
			int cnt = 0;
			
			for (int i = 1; i < 8; i += 2) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
					if (map[ny][nx] != 0) {
						cnt++;
					}
				}
			}
			
			map[y][x] += cnt;
		}
		
//		for (int[] is : map) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}
	}

	private static void rain(int[][] map, List<int[]> cloudList) {
		for (int[] cloud : cloudList) {
			map[cloud[0]][cloud[1]]++;
		}
		
//		for (int[] is : map) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}
	}

	private static void move(List<int[]> cloudList, int dir, int dis) {
		for (int[] cloud : cloudList) {
			int newY = (cloud[0] + dy[dir - 1] * dis) % N;
			int newX = (cloud[1] + dx[dir - 1] * dis) % N;
			
			cloud[0] = newY < 0 ? newY + N : newY;
			cloud[1] = newX < 0 ? newX + N : newX;
			
			tempPosition[cloud[0]][cloud[1]] = true;
		}
		
//		for (int[] arr : cloudList) {
//			System.out.println(arr[0] + " " + arr[1]);
//		}
	}
}