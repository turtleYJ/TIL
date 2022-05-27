import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자열 매칭문제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String A = st.nextToken();
        String B = st.nextToken();
        
        int lengthDiff = B.length() - A.length();
        
        int minCount = Integer.MAX_VALUE;
        
        for(int i = 0; i <= lengthDiff; i++) {
        	
        	int count = 0;
        	
        	for(int j = 0; j < A.length(); j++) {
        		
        		if(A.charAt(j) != B.charAt(j + i)) {
        			count++;
        		}
        	}
        	
        	minCount = Math.min(minCount, count);
        }
        
        System.out.println(minCount);
    }
}
