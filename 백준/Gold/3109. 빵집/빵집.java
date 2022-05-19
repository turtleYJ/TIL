import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count;
	static int R;
	static int C;
	static boolean[][] area;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		R = 0; // 행
		C = 0; // 열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		area = new boolean[R][C];
		
		for(int i = 0; i < R; i++) {
			String S = br.readLine();
			for(int j = 0; j < C; j++) {
				if(S.charAt(j) == 'x') {
					area[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			if(dfs(i, 0)) {
				count++;
			}
		}
		
		System.out.println(count);
		
		
		
		
		
		
	}

	private static boolean dfs(int i, int j) {
		if(!area[i][j]) {
			area[i][j]= true;
			
			if(j == C - 1) return true;
			
			if(i == 0) {
				if(dfs(i, j + 1)) {
					return true;
				} else if(dfs(i + 1, j + 1)) {
					return true;
				}
			} else if(i == R - 1) {
				if(dfs(i - 1, j + 1)) {
					return true;
				} else if(dfs(i, j + 1)) {
					return true;
				}
			} else {
				if(dfs(i - 1, j + 1)) {
					return true;
				} else if(dfs(i, j + 1)) {
					return true;
				} else if(dfs(i + 1, j + 1)) {
					return true;
				}
			}
		}
		
		return false;
		
	}
}