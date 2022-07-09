class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < signs.length; i++) {
			int num = absolutes[i];
			if (signs[i]) {
				answer += num;
			} else {
				answer -= num;
			}
		}
        
        return answer;
    }
}