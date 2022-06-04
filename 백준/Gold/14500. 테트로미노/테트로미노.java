import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static int[] dr = {1, -1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};
	private static boolean[][] isVisit;
	private static int localVal;
	private static int[][] board;
	private static int maxVal;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxVal = Integer.MIN_VALUE;
		isVisit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!isVisit[i][j]) {
					isVisit[i][j] = true;
					opt(i, j, board[i][j], 1);
					isVisit[i][j] = false;
					check(i, j);
					maxVal = Math.max(maxVal, localVal);
				}
			}
		}
		System.out.println(maxVal);
	}

	private static void check(int i, int j) {
		int basic = board[i][j];
		
		// 위
		if(i >= 1 && j >= 1 && j < M - 1) {
			maxVal = Math.max(maxVal, basic +  board[i - 1][j] + board[i][j + 1] + board[i][j - 1]);
		}
		// 아래
		if(i < N - 1 && j >= 1 && j < M - 1) {
			maxVal = Math.max(maxVal, basic +  board[i + 1][j] + board[i][j + 1] + board[i][j - 1]);
		}
		// 오른쪽
		if(i < N - 1 && i >= 1 && j < M - 1) {
			maxVal = Math.max(maxVal, basic + board[i - 1][j] +  board[i + 1][j] + board[i][j + 1]);
		}
		// 왼쪽
		if(i < N - 1 && i >= 1 && j >= 1) {
			maxVal = Math.max(maxVal, basic + board[i - 1][j] +  board[i + 1][j] + board[i][j - 1]);
		}
	}

	private static void opt(int r, int c, int sum, int depth) {
		if(depth == 4) {
			maxVal = Math.max(sum, maxVal);
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			
			if(nextR >= 0 && nextC >= 0 && nextR < N && nextC < M) {
				if(!isVisit[nextR][nextC]) {
					isVisit[nextR][nextC] = true;
					opt(nextR, nextC, sum + board[nextR][nextC], depth + 1);
					isVisit[nextR][nextC] = false;
				}
			}
		}
	}
}
