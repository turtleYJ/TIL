import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 중위 순회
// 트리
// 이진트리
public class Main {
	private static int[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine()); // 높이
		int size = (int)Math.pow(2, K) - 1; // 높이에 따른 노드의 개수 파악
		node = new int[size]; // 각 노드를 배열 자료구조에 넣어줌.
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < node.length; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		
		// 맵으로 각 레벨에 있는 노드들을 넣어준다.
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

	// 중위 순외 규칙에 따라 Root를 레벨별로 맵에 저장한다.
	private static void findRoot(int start, int end, int level, Map<Integer, List<Integer>> map) {
		int mid = (start + end) / 2;
		List<Integer> newList = map.getOrDefault(level, new ArrayList<Integer>());
		newList.add(node[mid]);
		map.put(level, newList);
		
		// 시작점과 끝 점이 같이지는 경우 트리의 말단이라 파악하여 재귀함수를 종료한다.
		if(start == end) return;
		
		// 왼쪽
		findRoot(start, mid - 1, level + 1, map);
		// 오른쪽
		findRoot(mid + 1, end, level + 1, map);
	}
}