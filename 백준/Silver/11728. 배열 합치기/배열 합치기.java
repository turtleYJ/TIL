import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[N];
		int[] arr2 = new int[M];
		int[] res = new int[N + M];
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		int i = 0;
		int j = 0; 
		int k = 0;
		StringBuilder sb = new StringBuilder();
		
		while (i < N && j < M) {
			if(arr1[i] > arr2[j]) {
//				res[k++] = arr2[j++];
				sb.append(arr2[j++] + " ");
			} else {
//				res[k++] = arr1[i++];
				sb.append(arr1[i++] + " ");
			}
		}
		
		while(i < N) {
//			res[k++] = arr1[i++];
			sb.append(arr1[i++] + " ");
		}
		while(j < M) {
//			res[k++] = arr2[j++];
			sb.append(arr2[j++] + " ");
		}
		
		System.out.println(sb);
//		for (int is : res) {
//			System.out.print(is);
//		}
	}
}