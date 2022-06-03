import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[][] matrix;
	private static int maxArea;
	private static int localArea;
	private static boolean[][] isVisit;
	private static int[] dr = {1, -1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for (int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxArea = 0;
		localArea = 0;
		isVisit = new boolean[N][M];
		
		backtracking(0, 0);
		
		System.out.println(maxArea);
		
		
	}

	private static void backtracking(int start, int wallNum) {
		
		if(wallNum == 3) {
			// 바이러스 먼저 퍼트리기 1을 만나면 멈춤
			spreadBR();
			
			// 안전영역의 크기 구하기
			findSafetyArea();
			
			maxArea = Math.max(maxArea, localArea);
			localArea = 0;
			isVisit = new boolean[N][M];
			
			return;
		}
		
		for (int i = start; i < N * M; i++) {
            int x = i / M;
            int y = i % M;

            if (matrix[x][y] == 0) {
            	matrix[x][y] = 1;
            	backtracking(i + 1, wallNum + 1);
                matrix[x][y] = 0;
            }
        }
		
	}

	private static void findSafetyArea() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matrix[i][j] == 0 && !isVisit[i][j]) {
					localArea++;
				}
			}
		}
	}

	private static void spreadBR() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matrix[i][j] == 2) {
					dfs(i , j);
				}
			}
		}
	}

	private static void dfs(int r, int c) {
		isVisit[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			
			if(nextR >= 0 && nextC >= 0 && nextR < N && nextC < M) {
				
				if(matrix[nextR][nextC] == 0 && !isVisit[nextR][nextC]) {
					dfs(nextR, nextC);
				}
			}
		}
	}
}