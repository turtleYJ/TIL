import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 이분 그래프
// 두 팀으로 나누어 같은 팀끼리는 인접하지 않는다.
// 정수값으로 1과 -1의 팀이 존재한다.
// 이어져있지 않은 트리 까지 생각해야 한다.
public class Main {

	private static int V;
	private static int E;
	private static ArrayList[] edge;
	private static Integer[] team;
	private static boolean OK;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = 0;
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		while(K-- > 0) {
			V = 0;
			E = 0;
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edge = new ArrayList[V + 1];
			
			for(int i = 1; i <= V; i++) {
				
				edge[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < E; i++) {
				
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				edge[v1].add(v2);
				edge[v2].add(v1);
			}
			
			team = new Integer[V + 1];
			
			OK = true;
			
			for(int i = 1; i <= V; i++) {
				if(team[i] == null) {
					dfs(i, 1);
				}
			}
			
			if(OK) {
				
				System.out.println("YES");
			} else {
				
				System.out.println("NO");
			}
		}
	}

	private static void dfs(int v, int t) {
		team[v] = t;
		
		int nextV = 0;
		
		for(int i = 0; i < edge[v].size(); i++) {
			
			nextV = (int) edge[v].get(i);
			
			if(team[nextV] == null) {
				dfs(nextV, -t);
			}
			
			if(team[nextV] == t) {
				OK = false;
				
				return;
			}
			
		}
	}
}