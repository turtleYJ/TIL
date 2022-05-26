import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int N;
	private static int count;
	private static int[] board;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 0;
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N];
		
		backTracking(0);
		
		System.out.println(count);
	}

	private static void backTracking(int depth) { // depth는 열을 뜻한다.
		if(depth == N) {
			
			count++;
			
			return;
		}
		
		// 특정 열(depth)을 고정시키고 행을 바꿔가며 퀸이 들어갈 위치를 찾는다.
		// i는 행이다.
		for(int i = 0; i < N; i++) { 
			
			board[depth] = i;
			
			if(isPossible(depth)) {
				
				backTracking(depth + 1);
			}
		}
	}
	
	private static boolean isPossible(int depth) {
		
		// i는 열이다.
		for(int i = 0; i < depth; i++) {
			// depth(열) 전까지, 즉 이전열에서 퀸이 어느 행에 있었는지를 파악한다.
			// 같은 행에 존재한다면 false리턴
			if(board[depth] == board[i]) { 
				
				return false;
			}
			// 대각선
			// 열의 차와 행의 차가 같을때 대각선상에 있다.
			else if(Math.abs(depth - i) == Math.abs(board[depth] - board[i])) {
				
				return false;
			}
		}
		
		return true;
	}
}