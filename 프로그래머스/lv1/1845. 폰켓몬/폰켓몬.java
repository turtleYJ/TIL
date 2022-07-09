import java.util.*;

class Solution {
	public int solution(int[] nums) {
        int answer = 0;
        
        int dep = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
        
        int setSize = set.size();
        
        if (setSize < dep) {
        	answer = setSize;
        } else {
        	answer = dep;
        }
        
        
        return answer;
    }
}