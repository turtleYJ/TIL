import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] isVisit;
	private static int maxLength;
	private static int maxNode;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());
		List<int[]>[] nodes = new ArrayList[V + 1];
		
		for (int i = 1; i < nodes.length; i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parentNode = Integer.parseInt(st.nextToken());
			
			while (true) {
				int childNode = Integer.parseInt(st.nextToken());
				
				if (childNode == -1) break;
				
				int length = Integer.parseInt(st.nextToken());
				
				nodes[parentNode].add(new int[] {childNode, length});
//				nodes[childNode].add(new int[] {parentNode, length});
			}
 		}
		
		maxLength = 0;
		maxNode = 0;
		
		isVisit = new boolean[V + 1];
		isVisit[1] = true;
		// 특정 정점(node)부터 가장 먼 노드를 찾는다.
		findMaxLength(nodes, 1, 0);
		
		isVisit = new boolean[V + 1];
		isVisit[maxNode] = true;
		// 특정 정점(node)부터 가장 먼 노드를 찾는다.
		findMaxLength(nodes, maxNode, 0);
		
		System.out.println(maxLength);
				
	}

	private static void findMaxLength(List<int[]>[] nodes, int node, int length) {
		if (length > maxLength) {
			maxLength = length;
			maxNode = node;
		}
		
		// 현재 정점과 이어진 정점들의 리스트
		List<int[]> nodeLists = nodes[node];
		
		for (int i = 0; i < nodeLists.size(); i++) {
			int child = nodeLists.get(i)[0];
			int len = nodeLists.get(i)[1];
			
			if (!isVisit[child]) {
				isVisit[child] = true;
				findMaxLength(nodes, child, length + len);
			}
		}
	}
}
