import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 완전 탐색
public class Main {

	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String Permutation = "";
		boolean[] isVisit = new boolean[N + 1];
		print(Permutation, 0, isVisit);
	}

	private static void print(String Per, int depth, boolean[] isVisit) {
		if(depth == N) {
			System.out.println(Per);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(!isVisit[i]) {
				String S = Per + i + " ";
				isVisit[i] = true;
				print(S, depth + 1, isVisit);
				isVisit[i] = false;
			}
		}
	}
}