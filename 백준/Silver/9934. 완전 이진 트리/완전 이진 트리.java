import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static int[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine()); // 높이
		int size = (int)Math.pow(2, K) - 1;
		node = new int[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < node.length; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, List<Integer>> map = new HashMap<>(); 
		findRoot(0, size - 1, 0, map);
		
		for (Integer i : map.keySet()) {
			List<Integer> list = map.get(i);
			
			for (Integer is : list) {
				System.out.print(is + " ");
			}
			System.out.println();
		}
	}

	private static void findRoot(int start, int end, int depth, Map<Integer, List<Integer>> map) {
		int mid = (start + end) / 2;
		List<Integer> newList = map.getOrDefault(depth, new ArrayList<Integer>());
		newList.add(node[mid]);
		map.put(depth, newList);
		
		if(start == end) return;
		
		// 왼쪽
		findRoot(start, mid - 1, depth + 1, map);
		// 오른쪽
		findRoot(mid + 1, end, depth + 1, map);
	}
}