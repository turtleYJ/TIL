class Solution {
    public int solution(int N) {
        String S = Integer.toBinaryString(N); 
        
        int res = 0;
        int count = 0;
        for (int i = 1; i < S.length(); i++) {
			if(S.charAt(i) == '0') {
				count++;
			} else {
				res = Math.max(count, res);
				count = 0;
			}
 		}
        
        return res;
    }
}