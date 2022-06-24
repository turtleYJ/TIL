import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 투 포인터
// (기본)
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int res = 0;
		while(start < arr.length) {
			// end가 끝에 도달하면 start를 강제로 올려줘서 와일문을 끝내준다.
			if (sum >= M || end == N) {
				if(sum == M) res++;
				sum -= arr[start];
				start++;
			}
			
			else {
				sum += arr[end];
				end++;
			}
		}
		System.out.println(res);
	}
}