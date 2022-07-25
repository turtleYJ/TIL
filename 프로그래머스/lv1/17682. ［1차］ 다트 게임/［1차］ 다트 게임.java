import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
         String num = "";
        
        for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);
			
			if (ch >= 48 && ch <= 57) {
				num += ch;
			}
			
			if (ch == 'S' || ch == 'D' || ch == 'T') {
				int numInt = 0;
				
				if (ch == 'S') {
					numInt = (int)Math.pow(Integer.valueOf(num), 1);
				}
				if (ch == 'D') {
					numInt = (int)Math.pow(Integer.valueOf(num), 2);
				} 
				if (ch == 'T') {
					numInt = (int)Math.pow(Integer.valueOf(num), 3);
				}
				
				num = "";
				st.add(numInt);
			}
			
			if (ch == '*' || ch == '#') {
				if (ch == '*') {
					if (st.size() > 1) {
						int temp1 = st.pop() * 2;
						int temp2 = st.pop() * 2;
						st.add(temp2);
						st.add(temp1);
					} else {
						st.add(st.pop() * 2);
					}
				} else {
					st.add(st.pop() * (-1));
				}
			}
		}
        
        for (Integer n : st) {
			answer += n;
		}
        
        return answer;
    }
}