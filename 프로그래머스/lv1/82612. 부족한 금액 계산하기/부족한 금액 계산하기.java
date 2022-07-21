class Solution {
    public long solution(int price, int money, int count) {
        long totalCst = 0;
        for (int i = 1; i <= count; i++) {
			totalCst += price * i;
		}
        
        long answer = 0;
        answer = totalCst - money;
        if (answer < 0) answer = 0;
        
        return answer;
    }
}