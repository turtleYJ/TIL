class Solution {
   public int solution(int n) {
        int answer = 0;
        
        for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				answer++;
			}
		}
        
        return answer;
    }
	
	private static boolean isPrime(int n) {
		if(n == 0 || n == 1) return false;
		for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
	}
}