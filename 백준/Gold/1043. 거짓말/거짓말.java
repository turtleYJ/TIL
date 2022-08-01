import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		// 진실을 알고있는 사
		boolean[] knowP = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			knowP[Integer.parseInt(st.nextToken())] = true;
		}
		
		// 파티원 묶기, 유니
		List<List<Integer>> partyList = new ArrayList<>();
		while (M-- > 0) {
			List<Integer> People = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			int p1 = Integer.parseInt(st.nextToken());
			People.add(p1);
			
			for (int i = 1; i < n; i++) {
				int p2 = Integer.parseInt(st.nextToken());
				People.add(p2);
				union(p1, p2);
				p1 = p2;
			}
			
			partyList.add(People);
		}
		
		
		for (int i = 1; i < knowP.length; i++) {
			if (knowP[i])  {
				knowP[find(i)] = true;
			}
		}
		
		int res = 0;
		for (List<Integer> party : partyList) {
			boolean pass = true;
			for (Integer p : party) {
				if (knowP[find(p)]) {
					pass = false;
					
					break;
				}
			}
			
			if (pass) res++;
		}
		
		System.out.println(res);
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(b < a) parent[a] = b;
		if(a < b) parent[b] = a;
	}
}