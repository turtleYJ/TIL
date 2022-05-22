import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] isVisit;
	private static int[] parent;
	private static ArrayList[] edge;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 0;
		N = Integer.parseInt(br.readLine());
		
		edge = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = null;
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			edge[x].add(y);
			edge[y].add(x);
		}
		
		isVisit = new boolean[N + 1];
		parent = new int[N + 1];
		
		dfs(1);
		
		for(int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

	private static void dfs(int x) {
		isVisit[x] = true;
		
		for(int i = 0; i < edge[x].size(); i++) {
			
			int temp = (int) edge[x].get(i);
			
			if(!isVisit[temp]) {
				
				parent[temp] = x;
				
				dfs(temp);
			}
		}
	}
}