import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] board;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[9][9];
		
		
		for(int i = 0; i < 9; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 9; j++) {
				
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);
	}

	private static void sudoku(int row, int col) {
		if(col == 9) {
			sudoku(row + 1, 0);
			
			return;
		}
		
		if(row == 9) {
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < 9; i++) {
				
				for (int j = 0; j < 9; j++) {
					
					sb.append(board[i][j]).append(' ');
				}
				
				sb.append('\n');
			}
			
			System.out.println(sb);
			
			System.exit(0);
		}
		
		if(board[row][col] == 0) {
			for(int i = 0; i < 9; i++) {
				
				if(isPossible(row, col, i + 1)) {
					board[row][col] = i + 1;
					
					// flag1
					sudoku(row, col + 1); 
				}
			}
			
			// 백트래킹! 특정값을 넣고 재귀함수를 진행했는데 깊은 곳에서 막혔을 시 다시 내려보낸다. flag1으로 돌아가서 다른 숫자를 대입해서 연산을 진행하게 된다.
			board[row][col] = 0;
			return;
		}
		
		sudoku(row, col + 1);
	}

	private static boolean isPossible(int row, int col, int value) {
		// 행, 열 검사
		for(int i = 0; i < 9; i++) {
			
			if(board[row][i] ==  value) {
				
				return false;
			}
			
			if(board[i][col] ==  value) {
				
				return false;
			}
		}
		
		int r = row / 3 * 3;
		int c = col / 3 * 3;
		
		for(int i = r; i < r + 3; i++) {
			
			for(int j = c; j < c + 3; j++) {
				
				if(board[i][j] ==  value) {
					
					return false;
				}
			}
		}
		
		return true;
	}
}