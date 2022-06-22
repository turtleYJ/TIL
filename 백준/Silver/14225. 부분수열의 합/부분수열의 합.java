import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] permutation;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		permutation = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < permutation.length; i++) {
			permutation[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Map<Integer, Boolean> map = new HashMap<>();
		
		calcPartSum(0, 0, 0, map);
		
		int res = 0;
		while(true) {
			Boolean ok = map.get(++res);
			
			if(ok == null) {
				break;
			}
		}
		
		System.out.println(res);
	}

	private static void calcPartSum(int idx, int depth, int sum, Map<Integer, Boolean> map) {
		if(depth == N) {
			return;
		}
		
		for (int i = idx; i < permutation.length; i++) {
			sum += permutation[i];
			map.put(sum, true);
			calcPartSum(i + 1, depth + 1, sum, map);
			sum -= permutation[i];
		}
	}
}