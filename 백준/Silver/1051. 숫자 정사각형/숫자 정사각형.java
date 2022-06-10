import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] lec;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lec = new int[N][M];
		String S = null;
		
		// 입력
		for (int i = 0; i < lec.length; i++) {
			S = br.readLine();
			for (int j = 0; j < lec[i].length; j++) {
				lec[i][j] = S.charAt(j);
			}
		}
		// 가장 큰 수부터 시작.
		int side = 1;
		for (int i = Math.min(N, M); i >= 2 ; i--) {
			if(findMaxSquare(i)) {
				side = i;
				break;
			}
		}
		System.out.println(side * side);
	}

	private static boolean findMaxSquare(int n) {
		boolean isFind = false;
		int newN = N - (n - 1);
		int newM = M - (n - 1);
		
		roof:
		for (int i = 0; i < newN; i++) {
			for (int j = 0; j < newM; j++) {
				if(lec[i][j] == lec[i][j + (n - 1)] && lec[i][j + (n - 1)] == lec[i + (n - 1)][j] && lec[i + (n - 1)][j] == lec[i + (n - 1)][j + (n - 1)]) {
					isFind = true;
					break roof;
				}
			}
		}
		return isFind;
	}
}