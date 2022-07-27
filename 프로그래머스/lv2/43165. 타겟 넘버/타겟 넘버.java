class Solution {
    private static int[] dO = {1, -1};
	private int answer;
	
	public int solution(int[] numbers, int target) {
        answer = 0;
        
        bt(numbers, target, 0, 0);
        
        return answer;
    }

	private void bt(int[] numbers, int target, int sum, int depth) {
		if (depth == numbers.length) {
			if (sum == target) {
				answer++;
			}
			
			return;
		}
		
		for (int j = 0; j < dO.length; j++) {
			int num = numbers[depth] * dO[j];
			sum += num;
			bt(numbers, target, sum, depth + 1);
			sum -= num;
		}
	}
}