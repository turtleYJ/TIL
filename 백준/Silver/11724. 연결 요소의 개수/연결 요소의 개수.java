import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 서로 연결되어있지 않은 여러 트리의 개수를 찾는 방법
public class Main {
	private static int N;
	private static int M;
	private static int[][] edge;
	private static boolean[] isVisit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 0; // 정점의 개수
		M = 0; // 간선의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edge = new int[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			edge[a][b] = 1;
			edge[b][a] = 1;
		}
		
		isVisit = new boolean[N + 1];
		
		int count = 0;
		for(int i = 1; i <= N; i++) {
			if(!isVisit[i]) {
				dfs(i);
				
				count++;
			}
		}
		
		System.out.println(count);
	}

	private static void dfs(int x) {
		isVisit[x] = true;
		
		for(int i = 1; i <= N; i++) {
			if(edge[x][i] == 1 && !isVisit[i]) {
				dfs(i);
			}
		}
	}
}