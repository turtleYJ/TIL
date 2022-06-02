import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 겹쳐지는 선분 길이의 총 합
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
		
		int start = arr[0][0];
		int end = arr[0][1];
		int length = end - start;
		
		for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i + 1][1] <= end) { 
				// 포함되는 경우
				continue;
			} else if(arr[i + 1][0] <= end && arr[i + 1][1] > end) { 
				// 겹치는 경우
				length += arr[i + 1][1] - end;
				end = arr[i + 1][1];
			} else { 
				// 겹치지 않는 경우
				length += arr[i + 1][1] - arr[i + 1][0];
				end = arr[i + 1][1];
			}
		}
		
		System.out.println(length);
	}
}