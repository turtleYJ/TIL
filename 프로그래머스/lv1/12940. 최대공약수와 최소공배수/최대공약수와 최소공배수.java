class Solution {
    public int[] solution(int n, int m) {
		
		int maxDividor = 0;
		int minMultiple = 0;
		
		for (int i = n; i > 0; i--) {
			if (n % i == 0 && m % i ==0) {
				maxDividor = i;
				break;
			}
		}
		
		int big = Math.max(n, m);
		for (int i = big; i < Long.MAX_VALUE; i += big) {
			if (i % n == 0 && i % m == 0) {
				minMultiple = i;
				break;
			}
		}
		
		int[] answer = new int[] {maxDividor, minMultiple};
		
        return answer;
    }
}