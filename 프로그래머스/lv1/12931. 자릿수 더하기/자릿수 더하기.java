import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String numStr = "" + n;

        for (int i = 0; i < numStr.length(); i++) {
			answer += numStr.charAt(i) - 48;
		}

        return answer;
    }
}