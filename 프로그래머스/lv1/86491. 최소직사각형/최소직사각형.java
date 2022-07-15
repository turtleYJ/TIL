class Solution {
    public int solution(int[][] sizes) {
        int bigMax = 0;
        int smallMax = 0;
        for (int i = 0; i < sizes.length; i++) {
			int num1 = sizes[i][0];
			int num2 = sizes[i][1];
			
			if (num1 >= num2) {
				bigMax = Math.max(bigMax, num1);
				smallMax = Math.max(smallMax, num2);
			} else {
				bigMax = Math.max(bigMax, num2);
				smallMax = Math.max(smallMax, num1);
			}
		}
        
        int answer = bigMax * smallMax;
        
        return answer;
    }
}