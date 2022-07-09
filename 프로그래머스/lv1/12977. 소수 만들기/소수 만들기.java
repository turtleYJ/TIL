class Solution {
    private static int answer;

	public int solution(int[] nums) {
	        answer = 0;

	        combi(nums, 0, 0, 0);

	        return answer;
    }

 	private static void combi(int[] arr, int sum, int idx, int depth) {
		
		if(depth == 3) {
			if (isPrime(sum)) {
				answer++;
			}
			
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			sum += arr[i];
			combi(arr, sum, i + 1, depth + 1);
            sum -= arr[i];
		}
	}

	private static boolean isPrime(int n) {
		if(n == 0 || n == 1) return false;
		for(int i = 2; i <= (int)Math.sqrt(n); i++){
	        if(n % i == 0) return false;
	    }
	    return true;
	}
    
    
}