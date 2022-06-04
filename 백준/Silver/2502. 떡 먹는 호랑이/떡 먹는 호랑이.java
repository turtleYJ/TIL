import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[31]; 
        
        for (int i = 2; i < dp.length; i++) {
			dp[0] = 1;
			dp[1] = 1;
			
			dp[i] = dp[i - 1] + dp[i - 2]; 
		}
        
        int x = 1; // 첫째날
        int y = 0; // 둘째날
        
        while(true) {
        	if((K - dp[D - 3] * x) % dp[D - 2] == 0) {
        		y = (K - dp[D - 3] * x) / dp[D - 2];
        		break;
        	}
        	x++;
        }
        System.out.println(x);
        System.out.println(y);
    }
}