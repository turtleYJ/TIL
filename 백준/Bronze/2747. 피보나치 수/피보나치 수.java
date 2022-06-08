import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//배낭에 물건 넣기
//DP
//다이나믹 프로그래밍
//바텀업
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(n, new HashMap<Integer, Long>()));
	}
	
    static long fibo(int n, HashMap<Integer, Long> memo) {
    	if (memo.containsKey(n)) return memo.get(n);
    	if (n <= 2) return 1;
    	memo.put(n, fibo(n - 1, memo) + fibo(n - 2, memo));
    	return memo.get(n);
    }
}