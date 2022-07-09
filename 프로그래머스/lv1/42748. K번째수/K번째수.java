import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int T = commands.length;
        int[] answer = new int[T];
        
        int t = 0;
        while (t < T) {
        	int i = commands[t][0];
        	int j = commands[t][1];
        	int k = commands[t][2];
        	int size = j - i + 1;
        	int[] newArr = new int[size];
        	
        	for (int l = 0; l < newArr.length; l++) {
				newArr[l] = array[(i - 1) + l];
			}
        	
        	Arrays.sort(newArr);
        	
        	answer[t++] = newArr[k - 1];
        	
        }
        
        
        return answer;
    }
}