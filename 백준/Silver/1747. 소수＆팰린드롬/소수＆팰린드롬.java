import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int i = N;
        
        while(true) {
        	if(isPrime(i) && isPalindrome(i)) {
        		System.out.println(i);
        		return;
        	}
        	i++;
        }
    }

	private static boolean isPrime(int n) {
		if(n == 0 || n == 1) return false;
		for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
	}

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