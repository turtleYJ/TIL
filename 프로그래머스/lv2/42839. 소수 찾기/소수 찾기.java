import java.util.*;

class Solution {
    private static int M;
	private static String nums;
	private static boolean[] isVisit;
    
    public int solution(String numbers) {
        nums = numbers;
        
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
		
		isVisit = new boolean[nums.length()];
		Set<Integer> numSet = new HashSet<>();
		
		combi("", numSet, 0);
        
        int answer = 0;
        for (Integer i : numSet) {
			if(!arr[i]) {
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
}