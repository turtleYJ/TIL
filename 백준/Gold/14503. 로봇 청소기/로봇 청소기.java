import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int count;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr[r][c] = 2;
		count = 1;
		dfs(r, c, direction, 0, arr);
		
		System.out.println(count);
	}

	private static void dfs(int r, int c, int direction, int turn, int[][] arr) {
		direction = direction % 4;
		
		int dr = 0;
		int dc = 0;
		
		// 4번 돌았을 때 => 뒤쪽이 빈칸(0)이면 뒤쪽으로 이동하고, 뒤쪽이 벽이라면(1) 작동을 멈춘다.
		if(turn == 4) {
			
			if(direction == 0) {
				dr = 1;
				dc = 0;
			}
			if(direction == 1) {
				dr = 0;
				dc = -1;
			}
			if(direction == 2) {
				dr = -1;
				dc = 0;
			}
			if(direction == 3) {
				dr = 0;
				dc = 1;
			}
			
			int nr = r + dr;
			int nc = c + dc;
			
			if(arr[nr][nc] != 1) {
				dfs(nr, nc, direction, 0, arr);
			} else {
				return;
			}
			
			return;
		}
		
		if(direction == 0) {
			dr = 0;
			dc = -1;
		}
		if(direction == 1) {
			dr = -1;
			dc = 0;
		}
		if(direction == 2) {
			dr = 0;
			dc = 1;
		}
		if(direction == 3) {
			dr = 1;
			dc = 0;
		}
		
		int nr = r + dr;
		int nc = c + dc;
		
		if(nr >= 0 && nc >= 0 && nr < N && nc < M) {
			// 왼쪽이 빈칸이고, 방문하지 않았을 때
			if(arr[nr][nc] == 0) {
				arr[nr][nc] = 2;
				
//				print(arr);
				
				count++;
				dfs(nr, nc, direction + 3, 0, arr);
			}
			// 왼쪽이 벽이거나, 방문한 칸일 때 => 원래의 자리에서 왼쪽으로 회전
 			else {
 				dfs(r, c, direction + 3, turn + 1, arr);
			}
		} 
	}

//	private static void print(int[][] arr) {
//		for (int[] is : arr) {
//			for (int i : is) {
//				System.out.print(i + " ");
//			}
//			System.out.println();
//		}
//	}
}