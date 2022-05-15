import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = 0;
		int M = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] accSum = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < accSum.length; i++) {
			accSum[i] = accSum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int end = 0;
		
		while(M-- > 0) {
			int sum = 0;
			
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			sum = accSum[end] - accSum[start - 1];
			
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
}