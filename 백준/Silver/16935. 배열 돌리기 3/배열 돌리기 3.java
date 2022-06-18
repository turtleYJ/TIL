import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int M;
	
	
	
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < R; i++) {
			int op = Integer.parseInt(st.nextToken());
			
			switch (op) {
			case 1:
				op1();
				break;
			case 2:
				op2();
				
				break;
			case 3:
				op3();
				
				break;
			case 4:
				op4();
				
				break;
			case 5:
				op5();
				
				break;
			case 6:
				op6();
				
				break;
			}
			
			
			
		}
		
		// 출력
		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	

	private static void op6() {
		int[][] ex  = arr.clone();
		int R = ex.length;
		int C = ex[0].length;
		arr = new int[R][C];		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				// 1 -> 4
				if(i < R / 2 && j < C / 2) arr[R / 2 + i][j] = ex[i][j];
				// 2 -> 1
				if(i < R / 2 && j >= C / 2) arr[i][j - C / 2] = ex[i][j];
				// 3 -> 2
				if(i >= R / 2 && j >= C / 2) arr[i - R / 2][j] = ex[i][j];
				// 4 -> 3
				if(i >= R / 2 && j < C / 2) arr[i][C / 2 + j] = ex[i][j];
			}
		}		
	}

	private static void op5() {
		int[][] ex  = arr.clone();
		int R = ex.length;
		int C = ex[0].length;
		arr = new int[R][C];		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				// 1 -> 2
				if(i < R / 2 && j < C / 2) arr[i][C / 2 + j] = ex[i][j];
				// 2 -> 3
				if(i < R / 2 && j >= C / 2) arr[R / 2 + i][j] = ex[i][j];
				// 3 -> 4
				if(i >= R / 2 && j >= C / 2) arr[i][j - C / 2] = ex[i][j];
				// 4 -> 1
				if(i >= R / 2 && j < C / 2) arr[i - R / 2][j] = ex[i][j];
			}
		}
	}

	private static void op4() {
		int[][] ex  = arr.clone();
		int R = ex[0].length;
		int C = ex.length;
		arr = new int[R][C];
		
		for (int i = 0; i < ex.length; i++) {
			for (int j = 0; j < ex[i].length; j++) {
				arr[R - 1 - j][i] = ex[i][j];
			}
		}		
	}

	private static void op3() {
		int[][] ex  = arr.clone();
		int R = ex[0].length;
		int C = ex.length;
		arr = new int[R][C];
		
		for (int i = 0; i < ex.length; i++) {
			for (int j = 0; j < ex[i].length; j++) {
				arr[j][C - 1 - i] = ex[i][j];
			}
		}
	}

	private static void op2() {
		int n = arr.length;
		int m = arr[0].length;
		int exchangeNum = m / 2;
		
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < exchangeNum; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[i][m - 1 - j];
				arr[i][m - 1 - j] = temp;
			}
		}
	}

	private static void op1() {
		int n = arr.length;
		int m = arr[0].length;
		int exchangeNum = n / 2;
		
		int temp = 0;
		for (int i = 0; i < exchangeNum; i++) {
			for (int j = 0; j < m; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[n - 1 -i][j];
				arr[n - 1 -i][j] = temp;
			}
		}
	}
}