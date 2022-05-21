import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static boolean[] isVisit;
	private static int[] count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 0;
		M = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isVisit = new boolean[Math.max(N, M) * 2 + 1];
		count = new int[Math.max(N, M) * 2 + 1];
		
		count[M] = Integer.MAX_VALUE;
		
		if(N == M) {
			System.out.println(0);
		} else {
			bfs(N);
			System.out.println(count[M]);
		}
		
	}

	private static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		isVisit[n] = true;
		
		q.add(n);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			int[] d = {1, -1, x};
			
			int nextX = 0;
			if(x > M) {
				nextX = x - 1;
				
				if(nextX == M) {
					count[nextX] = Math.min(count[M], count[x] + 1);
				} else {
					if(nextX >= 0 && nextX < isVisit.length && !isVisit[nextX]) {
						q.add(nextX);
						count[nextX] = count[x] + 1;
						isVisit[nextX] = true;
					}
				}
				
			} else {
				for(int i = 0; i <3; i++) {
					nextX = x + d[i];
					
					if(nextX == M) {
						count[nextX] = Math.min(count[M], count[x] + 1);
					} else {
						if(nextX >= 0 && nextX < isVisit.length && !isVisit[nextX]) {
							if(d[i] != 0) {
								q.add(nextX);
								
								count[nextX] = count[x] + 1;
							}
							isVisit[nextX] = true;
						}
					}
				}
			}
		}
	}
}