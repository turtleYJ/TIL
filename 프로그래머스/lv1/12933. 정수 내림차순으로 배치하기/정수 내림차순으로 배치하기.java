import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String S = "" + n;
        String[] arrStr = S.split("");
        Arrays.sort(arrStr, Collections.reverseOrder());
        
        String resStr = "";
        for (String s : arrStr) {
        	resStr += s;
		}
        
        answer = Long.parseLong(resStr);
        
        return answer;
    }
}