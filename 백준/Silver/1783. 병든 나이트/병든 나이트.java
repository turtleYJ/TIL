import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 그려보면 답이 나온다
// N이 1인 경우, 무조건 1
// N이 2인 경우, M이 3, 5, 7 즉 2칸씩 늘어날때마다 1씩 추가되는데 7 이상은 모두 4이다.
// N이 3이상인 경우, M이 7보다 작은 경우 4까지는 1씩증가하며 4이상부터 7미만까지는 모두 4이다. 그 이후는 M - 2개
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 0; // 세로
		int M = 0; // 가로
		int result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(N == 1) {
			result = 1;
		} else if(N == 2) {
			if(M < 7) {
				result = 1+ (M-1)/2;
			} else {
				result = 4;
			}
		} else {
			if(M <= 4) {
				result = M;
			} else if(M < 7){
				result = 4;
			} else {
				result = M - 2;
			}
		}
		
		System.out.println(result);
	}
}