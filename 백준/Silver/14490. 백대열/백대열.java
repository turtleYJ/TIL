import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 동일한 문자열의 개수 파악
public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int cf = 0 ;
        
        // 최대 공약수를 구한다.
        for(int i = 1; i <= Math.min(A, B); i++) {
        	
        	if(A % i == 0 && B % i == 0) {
        		
        		cf = Math.max(cf, i);
        	}
        }
        
        System.out.println(A / cf + ":" + B / cf);
    }
}