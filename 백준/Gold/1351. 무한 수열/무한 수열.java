import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// dp를 Map을 이용하여 풀이
public class Main {

	private static HashMap<Long, Long> map;
	private static long P;
	private static long Q;

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        
        map = new HashMap<>();
        
        System.out.println(solve(N));
        
    }

	private static long solve(long n) {
		if(n == 0) return 1;
		if(map.containsKey(n)) return map.get(n);
		
		map.put(n, solve(n / P) + solve(n/Q));
		
		return map.get(n);
	}
}