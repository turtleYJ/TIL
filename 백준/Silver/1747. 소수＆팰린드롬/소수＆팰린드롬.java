import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean arr[] = new boolean[10000001];
        
        arr[0] = true;
		arr[1] = true;
        
		// 에라토스테네스의 체
        for(int i = 2; i <= Math.sqrt(10000001); i++) {
			// 아래에서 i의 제곱수 부터 검사를 시작함으로 전체범위의 제곱근까지 검사함.
			for(int j = i*i; j < 10000001; j += i) {
				arr[j] = true;
			}
		}
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = N; i < 10000001; i++) {
        	
        	if(!arr[i] && isPalindrome(i)) {
        		System.out.println(i);
        		return;
        	}
		}
    }
	// 팰린드롬 수인지 판별
	private static boolean isPalindrome(int value) {
		String S = Integer.toString(value);
    	
    	for (int j = 0; j < S.length() / 2; j++) {
			if(S.charAt(j) != S.charAt(S.length() - 1 - j)) {
				return false;
			}
		}
		return true;
	}
}
