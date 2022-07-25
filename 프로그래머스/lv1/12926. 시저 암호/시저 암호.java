class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int newChar = 0;
            
            if (ch == 32) {
				newChar = 32;
			}
			
			if (ch >= 97 && ch <= 122) {
				newChar = ch + n;
				
				newChar = (newChar > 122) ? 96 + (newChar % 122) : newChar;
			}
			
			if (ch >= 65 && ch <= 90) {
				newChar = ch + n;
				
				newChar = (newChar > 90) ? 64 + (newChar % 90) : newChar;
			}
			
			answer += (char)newChar;
		}
        
        return answer;
    }
}