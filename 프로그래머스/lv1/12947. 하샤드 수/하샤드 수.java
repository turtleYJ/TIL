class Solution {
    public boolean solution(int x) {
		String numStr = "" + x;
		int divider = 0;
		
		for (int i = 0; i < numStr.length(); i++) {
			divider += numStr.charAt(i) - 48;
		}
		
		boolean answer = true;
		if (x % divider != 0) {
			answer = false;
		}
		
        return answer;
    }
}