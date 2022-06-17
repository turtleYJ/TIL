import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] dy = {0, 1, 0 , -1};
	private static int[] dx = {1, 0, -1 , 0};
	private static int[][] arr;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int shell = Math.min(M, N) / 2;
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int j = 0; j < shell; j++) {
			int div = R % (((N - (j*2 + 1)) + (M - (j*2 + 1))) * 2);
			
			move(j, div);
			
		}
		
		// 출력
		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static void move(int j, int div) {
		for (int i = 0; i < div; i++) {
			int y = j;
			int x = j;
			
			int temp = arr[x][y];
			
			
			for (int k = 0; k < 4; k++) {
				
				while(true) {
					int ny = y + dy[k];
					int nx = x + dx[k];
					
					if(ny >= N - j || nx >= M - j || ny < 0 + j || nx < 0 + j) break;
					
					arr[y][x] = arr[ny][nx];
					y = ny;
					x = nx;
				}
			}
			arr[j + 1][j] = temp;
		}
	}
}