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
		
		boolean[] arr = new boolean[N + 1];
		
		int count = 0;
		int num = 0;
		roof:
		for (int i = 2; i < N + 1; i++) {
			for (int j = 2; j < N + 1; j++) {
				if(j % i == 0 && !arr[j]) {
					arr[j] = true;
					count++;
					if (count == K) {
						num = j;
						break roof;
					}
				}
			}
		}
		System.out.println(num);
	}
}