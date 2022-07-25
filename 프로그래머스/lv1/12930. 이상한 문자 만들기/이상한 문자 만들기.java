import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        
         for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if (ch == ' ') {
				cnt = 0;
				answer += ch;
				
				continue;
			}
			
			if (cnt % 2 == 0) {
				answer += Character.toString(ch).toUpperCase();
			} else {
				answer += Character.toString(ch).toLowerCase();
			}
			
			cnt++;
		}
        
        return answer;
    }
}