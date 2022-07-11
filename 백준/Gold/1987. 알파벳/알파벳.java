import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] dy = {1, -1, 0, 0};
	private static int[] dx = {0, 0, 1, -1};
	private static int R;
	private static int C;
	private static char[][] board;
	private static int res;
	private static boolean[][] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for (int i = 0; i < board.length; i++) {
			String S = br.readLine();
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = S.charAt(j);
			}
		}
		
		isVisit = new boolean[R][C];
		Map<Character, Boolean> map = new HashMap<>();
		isVisit[0][0] = true;
		map.put(board[0][0], true);
		res = 0;
		dfs(map, isVisit, 0, 0, 1);
		
		System.out.println(res);
		

	}

	private static void dfs(Map<Character, Boolean> map, boolean[][] isVisit, int y, int x, int cnt) {
		
//		if (map.containsValue(Integer.valueOf(2))) {
//			res = Math.max(res, cnt);
//			
//			return;
//		}
		
		res = Math.max(res, cnt);
		
//		HashMap<Character, Integer> copyMap = new HashMap<>(map);
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= 0 && nx >= 0 && ny < R && nx < C && !isVisit[ny][nx] && !map.getOrDefault(board[ny][nx], false)) {
				isVisit[ny][nx] = true;
				map.put(board[ny][nx], true);
//				map.put(board[ny][nx], map.getOrDefault(board[ny][nx], 0) + 1);
				dfs(map, isVisit, ny, nx, cnt + 1);
//				map.put(board[ny][nx], map.get(board[ny][nx]) - 1);
				map.put(board[ny][nx], false);
				isVisit[ny][nx] = false;
			}
		}
	}
}