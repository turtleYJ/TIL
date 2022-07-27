import java.util.Stack;

class Solution {
    public int solution(String s) {
		
		Stack<Character> st = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if (!st.isEmpty() && st.peek() == ch) {
				st.pop();
			} else {
				st.push(ch);
			}
		}
		
		int answer = -1;
		if (st.isEmpty()) answer = 1;
		else answer = 0;

        return answer;
    }
}