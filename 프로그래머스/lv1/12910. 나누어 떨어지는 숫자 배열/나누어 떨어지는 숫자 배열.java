import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> numList = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				numList.add(arr[i]);
			}
		}
        
        if (numList.isEmpty()) {
        	answer = new int[] {-1};
        } else {
        	answer = new int[numList.size()];
        	
        	for (int i = 0; i < answer.length; i++) {
				answer[i] = numList.get(i);
			}
        	
        	Arrays.sort(answer);
        }
        
        
        return answer;
    }
}