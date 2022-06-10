import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] medals = new int[N + 1][3];
		
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			medals[idx][0] = Integer.parseInt(st.nextToken());
			medals[idx][1] = Integer.parseInt(st.nextToken());
			medals[idx][2] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for (int i = 1; i < medals.length; i++) {
			if(i != K) {
				if(compare(i, K, medals)) {
					count++;
				}
			}
		}
		System.out.println(count + 1);
	}

	private static boolean compare(int another, int target, int[][] medals) {
		boolean isLose = true;
		
		if(medals[target][0] > medals[another][0]) isLose = false;
		if(medals[another][0] == medals[target][0] && medals[another][1] < medals[target][1]) isLose = false;
		if(medals[another][0] == medals[target][0] && medals[another][1] == medals[target][1] && medals[another][2] <= medals[target][2]) isLose = false;
		
		return isLose;
	}
}