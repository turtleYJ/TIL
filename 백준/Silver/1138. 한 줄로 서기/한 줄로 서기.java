import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		List<Integer> order = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		order.add(N);
		for (int i = arr.length - 2; i >= 0; i--) {
			int count = 0;
			int j = 0;
			while(count != arr[i]) {
				count++;
				j++;
			}
			order.add(j, i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < order.size(); i++) {
			sb.append(order.get(i) + " ");
		}
		System.out.println(sb);
	}
}