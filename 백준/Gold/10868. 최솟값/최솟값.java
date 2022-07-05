import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 세그먼트 트리
// 최소값
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 세그먼트 트리의 높이
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		// 세그먼트 트리의 최대 사이즈
		int tree_size = (1 << (h + 1));
		long[] arr = new long[N];
		long[] treeMax = new long[tree_size];
		long[] treeMin = new long[tree_size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		initMin(arr, treeMin, 1, 0, N - 1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			long min = min(treeMin, 1, 0 , N - 1, a - 1, b - 1);
			
			sb.append(min).append('\n');
		}
		
		System.out.println(sb);
		
	}

	private static long min(long[] treeMin, int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return Long.MAX_VALUE;
		}
		
		if (left <= start && end <= right) {
			return treeMin[node]; 
		}
		
		return Math.min(min(treeMin, node * 2, start, (start + end) / 2, left, right), min(treeMin, node * 2 + 1, (start + end) / 2 + 1, end, left, right));
	}

	private static long initMin(long[] arr, long[] tree, int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		} else {
			return tree[node] = Math.min(initMin(arr, tree, node * 2, start, (start  + end) / 2), initMin(arr, tree, node * 2 + 1, (start  + end) / 2 + 1, end));
		}
	}
}