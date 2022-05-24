import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int maxLength;
	private static int maxNode;
	private static int n;
	private static boolean[] isVisit;
	private static ArrayList<int[]>[] edge;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n =  0;
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		
		int parent = 0;
		int child = 0;
		int lengthWeight;
		edge = new ArrayList[n + 1];
		
		for(int i = 0; i <= n; i++) {
			edge[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			parent = Integer.parseInt(st.nextToken());
			child = Integer.parseInt(st.nextToken());
			lengthWeight = Integer.parseInt(st.nextToken());
			
			edge[parent].add(new int[] {child, lengthWeight});
			edge[child].add(new int[] {parent, lengthWeight});
		}
		
		maxLength = 0;
		maxNode = 0;
		
		isVisit = new boolean[n + 1];
		dfs(1, 0); // 루트를 기준으로 시작한다.
		
		isVisit = new boolean[n + 1];
		dfs(maxNode, 0); // 루트를 기준으로 가장 긴 길이를 시작점으로 지름을 찾는다.
		
		System.out.println(maxLength);
	}

	private static void dfs(int node, int length) {
		
		isVisit[node] = true;
		
		if(length > maxLength) {
			
			maxLength = length;
			
			maxNode = node;
		}
		
		for(int i = 0; i < edge[node].size(); i++) {
			int[] temp = edge[node].get(i);
			
			int nextNode = temp[0];
			int nextWeight = temp[1];
			
			if(!isVisit[nextNode]) {
				
				dfs(nextNode, length + nextWeight);
			}
		}
	}
}