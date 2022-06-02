import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[0] - o2[0];
			}
		});
		
		int start = arr[0][0];
		int end = arr[0][1];
		int sum = end - start;
		
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i + 1][0] <= end && arr[i + 1][1] <= end) {
				continue;
			} else if (arr[i + 1][0] <= end && arr[i + 1][1] > end){
				sum += arr[i + 1][1] - end;
				end = arr[i + 1][1];
			} else {
				sum += arr[i + 1][1] - arr[i + 1][0];
				end = arr[i + 1][1];
			}
		}
				
		System.out.println(sum);
	}
}