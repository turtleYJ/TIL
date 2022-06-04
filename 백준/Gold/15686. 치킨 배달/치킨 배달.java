import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static int[][] city;
	private static int minLength;
	private static ArrayList<int[]> restList;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		restList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		minLength = Integer.MAX_VALUE;
		optimize(0, 0);
		
		System.out.println(minLength);
	}

	private static void optimize(int idx, int depth) {
		// 치킨집 배정이 끝난 후
		if(depth == M) {
			// 치킨거리 구하기
			int localLength = 0;
			localLength = calcLength();
			
			minLength = Math.min(minLength, localLength);
			
			return;
		}
		
		// 치킨집을 M개만 배정
		for (int i = idx; i < N * N; i++) {
			int r = i / N;
			int c = i % N;
			
			if(city[r][c] == 2) {
//				picked[r][c] = true;
				restList.add(new int[] {r, c});
				optimize(i + 1, depth + 1);
//				picked[r][c] = false;
				restList.remove(restList.size() - 1);
			}
		}
	}

	private static int calcLength() {
		int localOptLength = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(city[i][j] == 1) {
					int optLength = Integer.MAX_VALUE;
					
					for (int k = 0; k < restList.size(); k++) {
						int[] coor = restList.get(k);
						int length = Math.abs(i - coor[0]) + Math.abs(j - coor[1]);
						
						optLength = Math.min(optLength, length);
					}
					localOptLength += optLength;
				}
			}
		}
		return localOptLength;
	}
}