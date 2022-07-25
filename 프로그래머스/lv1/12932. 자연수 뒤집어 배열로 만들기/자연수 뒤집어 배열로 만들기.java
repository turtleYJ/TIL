class Solution {
    public int[] solution(long n) {
        String numStr = "" + n;
        StringBuilder sb = new StringBuilder(numStr).reverse();
        
        int[] answer = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
			answer[i] = sb.charAt(i) - 48;
		}
        
        return answer;
    }
}