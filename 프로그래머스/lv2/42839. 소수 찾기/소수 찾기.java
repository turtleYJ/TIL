import java.util.*;

class Solution {
    private static int M;
	private static String nums;
	private static boolean[] isVisit;
    
    public int solution(String numbers) {
        nums = numbers;
        
		isVisit = new boolean[nums.length()];
		Set<Integer> numSet = new HashSet<>();
		
		combi("", numSet, 0);
        
        int answer = 0;
        for (Integer i : numSet) {
			if(isPrime(i)) {
				answer++;
			}
		}
        
        return answer;
    }
    
    private static void combi(String num, Set<Integer> numSet, int depth) {
		if(depth == nums.length()) {
			return;
		}
		
		String S = num;
		
		for(int i = 0; i < nums.length(); i++) {
			if(!isVisit[i]) {
				S += nums.charAt(i);
				if(S.charAt(0) == '0') {
					S = num;
					continue;
				}
				isVisit[i] = true;
				numSet.add(Integer.parseInt(S));
				combi(S, numSet, depth + 1);
				isVisit[i] = false;
				S = num;
			}
		}
	}
    
    private static boolean isPrime(int n) {
		if(n == 0 || n == 1) return false;
		for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
	}
}