class Solution {
    public int solution(int num) {
        long n = num;
		if (n == 1) return 0;
        
		int answer = 0;
        while (true) {
        	if (n == 1) break;
        	if (answer > 500) {
        		answer = -1;
        		
        		break;
        	}
        	
        	if (n % 2 == 0) {
        		n /= 2;
        	} else {
        		n = n * 3 + 1;
        	}
        	
        	answer++;
        }
        
    	return answer;
    }
}