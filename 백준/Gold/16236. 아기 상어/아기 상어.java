import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {
	
	private static int[] dy = {-1, 0, 1, 0};
	private static int[] dx = {0, -1, 0, 1};
	private static int res;
	private static int N;
	private static int[][] arr;
	private static int size;
	private static int stack;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int[] cur = null;
		
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				int n = Integer.parseInt(st.nextToken());
				
				if (n == 9) {
					cur = new int[] {i, j};
					arr[i][j] = 0;
					continue;
				}
				
				arr[i][j] = n;
			}
		}
		
		res = 0;
		size = 2;
		stack = 0;
		eat(cur);
		
		System.out.println(res);
	}
	
	// bfs
	private static void eat(int[] cur) {
		
		while (true) {
			boolean[][] isVisit = new boolean[N][N];
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
		            o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
		    );
			
			pq.add(new int[] {cur[0], cur[1], 0});
			isVisit[cur[0]][cur[1]] = true;
			
			// 먹었는지 확인
			boolean ck = false;
			
			while(!pq.isEmpty()) {
				cur = pq.poll();
				
				if (arr[cur[0]][cur[1]] != 0 && arr[cur[0]][cur[1]] < size) {
					arr[cur[0]][cur[1]] = 0;
					res += cur[2];
					ck = true;
					stack++;
					
					if (stack >= size) {
						size++;
						stack = 0;
					}
					
					break;
				}
				
				for (int i = 0; i < 4; i++) {
					int ny = cur[0] + dy[i];
					int nx = cur[1] + dx[i];
					
					if (ny >= 0 && nx >= 0 && ny < N && nx < N && arr[ny][nx] <= size) {
						if (!isVisit[ny][nx]) {
							
							isVisit[ny][nx] = true;
							pq.add(new int[] {ny, nx, cur[2] + 1});
						}
					}
				}
			}
			
			if (!ck) {
				break;
			}
		}
	}
}