import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int M;
	private static int N;
	private static int K;
	private static boolean[][] papper;
	private static int[] dr = {1, -1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};
	private static int area;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = 0; // row 
		N = 0; // column
		K = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		papper = new boolean[M][N];
		
		// 직사각형 입력
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int xL = Integer.parseInt(st.nextToken());
			int yL = Integer.parseInt(st.nextToken());
			int xR = Integer.parseInt(st.nextToken());
			int yR = Integer.parseInt(st.nextToken());
			
			for(int i = yL; i < yR; i++) {
				for(int j = xL; j < xR; j++) {
					if(papper[i][j]) continue;
					
					papper[i][j] = true;
				}
			}
		}
		
		int count = 0; // 영역의 갯수
		StringBuilder sb = new StringBuilder();
		List<Integer> areaList = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				
				if(!papper[i][j]) {
					area = 0;
					dfs(i, j);
					
					areaList.add(area);
					
					count++;
				}
			}
		}
		
		Collections.sort(areaList);
		
		System.out.println(count);
		
		for (Integer result : areaList) {
			System.out.print(result + " ");
		}
	}

	private static void dfs(int r, int c) {
		papper[r][c] = true;
		area++;
		
		for(int i = 0; i < 4; i ++) {
			
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			
			if(nextR >= 0 && nextC >= 0 && nextR < M && nextC < N) {
				if(!papper[nextR][nextC]) {
					dfs(nextR, nextC);
				}
			}
		}
	}
}