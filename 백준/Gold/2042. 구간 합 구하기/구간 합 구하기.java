import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 세그먼트 트리
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int num = M + K;
		// 트리의 높이
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		// 트리의 사이즈(노드의 수)
//		int tree_size = (int)Math.pow(2, h + 1);
		int tree_size = (1 << (h + 1));
		long[] arr = new long[N];
		long[] tree = new long[tree_size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		init(arr, tree, 1, 0, N - 1);
		StringBuilder sb = new StringBuilder();
		
		while (num-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			// 숫자 변경
			if (a == 1) {
				long diff = c - arr[b - 1];
				arr[b - 1] = c;
				
				update(tree, 1, 0, N - 1, b - 1, diff);
			} 
			// 합을 구하여 출력
			else if (a == 2) {
				
				sb.append(sum(tree, 1, 0, N - 1, b - 1, c - 1)).append('\n');
			}
		}
		
		System.out.println(sb);
	}

	// 더할 인덱스의 범위(left ~ right), 노드의 담당 범위(start ~ end)
	private static long sum(long[] tree, int node, int start, int end, int left, long right) {
		// 노드의 범위 밖에 더할 범위가 존재한다면 (관련 없는 노드이다.)
		if (left > end || right < start) {
			return 0;
		}
		// 노드의 범위가 더할 범위에 포함될 때(그 노드범위의 합을 리턴하여 상위 재귀식에서 더해질 수 있도록 한다.)
		if (left <= start && end <= right) {
			return tree[node];
		}
		// 그 밖에, 노드의 범위[start ~ end]가 전체 합산핧 범위[left ~ right]를 완전히 포함하는 경우 => 하위 노드로 가서 노드의 범위가 합산범위에 포함되는 것을 찾는다.
		return sum(tree, node * 2, start, (start + end) / 2, left, right) + sum(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}

	// 여기서 index는 바꿔줘야할 숫자의 인덱스이다.
	private static void update(long[] tree, int node, int start, int end, int index, long diff) {
		// 범위(start ~ end)에 index가 포함되지 않으면 리턴해준다.
		if (index < start || index > end) return;
		// 범위(start ~ end)에 index가 포함된다면 차이값(diff)을 더해준다.
		tree[node] = tree[node] + diff;
		// 리프가 아니면 하위 노드들도 탐색한다.
		if(start != end) {
			// 왼쪽
			update(tree, node * 2, start, (start + end) / 2, index, diff);
			// 오른쪽
			update(tree, node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
		}
	}

	// 초기화
	private static long init(long[] arr, long[] tree, int node, int start, int end) {
		// 만약 리프노드에 닿는 다면
		// 리프 노드는 배열의 그 원소를 가진다.
		if (start == end) {
			return tree[node] = arr[start];
		} else {
			return tree[node] = init(arr, tree, node * 2, start, (start  + end) / 2) + init(arr, tree, node * 2 + 1, (start  + end) / 2 + 1, end);
		}
	}
}
