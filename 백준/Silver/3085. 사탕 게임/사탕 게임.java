import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static char[][] arr;
	private static int N;
	private static int[] dr = {1, 0};
	private static int[] dc = {0, 1};
	private static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		String S = "";
		
		for (int i = 0; i < N; i++) {
			S = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = S.charAt(j);
			}
		}
		
		res = Integer.MIN_VALUE;
		
		if((res = findMax()) == N) {
			System.out.println(N);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(res != N) {
					change(i, j);
				}
			}
		}
		
		System.out.println(res);
		
	}

	private static void change(int r, int c) {
		
		for (int i = 0; i < 2; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
				char temp1 = arr[r][c];
				char temp2 = arr[nr][nc];
				arr[r][c] = temp2;
				arr[nr][nc] = temp1;
				res = Math.max(findMax(), res);
				if (res == N) {
					return;
				}
				arr[r][c] = temp1;						
				arr[nr][nc] = temp2;
			}
		}
	}

	private static int findMax() {
		int max = 0;
		int countR = 1;
		int countC = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(j > 0 && arr[i][j] == arr[i][j - 1]) {
					countR++;
				} else {
					countR = 1;
				}
				if(j > 0 && arr[j][i] == arr[j - 1][i]) {
					countC++;
				} else {
					countC = 1;
				}
				max = Math.max(Math.max(countR, countC), max);
			}
		}
		return max;
	}
}