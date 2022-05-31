import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> numberMap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			
			int tempNum = Integer.parseInt(st.nextToken());
			
			numberMap.put(tempNum, numberMap.getOrDefault(tempNum, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			
			sb.append(numberMap.getOrDefault(Integer.parseInt(st.nextToken()), 0) + " ");
		}
		
		System.out.println(sb);
    }
}