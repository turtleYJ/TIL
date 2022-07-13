import java.util.*;

class Solution {
    public Integer[] solution(int[] numbers) {
//        Set<Integer> numsSet = new HashSet<>();
        List<Integer> numsList = new ArrayList<>();
        findNum(numbers, numsList, 0, 0, 2);
        
        Integer[] answer = numsList.toArray(new Integer[numsList.size()]);
        Arrays.sort(answer);
        
        return answer;
    }

	private void findNum(int[] numbers, List<Integer> numsList, int idx, int sum, int depth) {
		
		if (depth == 0) {
			
			if (!numsList.contains(sum)) {
				numsList.add(sum);
			}
			
			return;
		}
		
		for (int i = idx; i < numbers.length; i++) {
			sum += numbers[i];
			findNum(numbers, numsList, i + 1, sum, depth - 1);
			sum -= numbers[i];
		}
	}
}