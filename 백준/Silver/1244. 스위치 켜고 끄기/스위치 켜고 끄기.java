import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int gen = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if(gen == 1) {
				switchM(idx);
			} else {
				switchW(idx);
			}
		}
		
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			count++;
			if(count == 20) {
				System.out.println();
				count = 0;
			}
		}
	}

	private static void switchW(int idx) {
		int range = Math.min(N - idx, idx - 1);
		if(arr[idx] == 1) arr[idx] = 0;
		else arr[idx] = 1;
		
		
		for (int i = 1; i <= range; i++) {
			if(arr[idx + i] == arr[idx - i]) {
				if(arr[idx + i] == 1) {
					arr[idx + i] = 0;
					arr[idx - i] = 0;
				} else {
					arr[idx + i] = 1;
					arr[idx - i] = 1;
					
				}
			} else {
				break;
			}
		}
	}

	private static void switchM(int idx) {
		int range = N / idx;
		
		for (int i = 1; i <= range; i++) {
			int temp = arr[idx * i];
			if(temp == 0) arr[idx * i] = 1;
			if(temp == 1) arr[idx * i] = 0;
		}
	}
}