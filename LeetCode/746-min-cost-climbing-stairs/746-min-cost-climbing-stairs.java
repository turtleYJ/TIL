class Solution {
    
    static Integer[] DP;
	static int[] costClone;
    
    public int minCostClimbingStairs(int[] cost) {
        costClone = cost;
        DP = new Integer[cost.length + 1];
        
        DP[0] = 0;
        DP[1] = 0;
        
        return opt(cost.length);
    }
    
    private int opt(int n) {
		if(DP[n] != null) return DP[n];
		DP[n] = Math.min(opt(n - 2) + costClone[n - 2], opt(n - 1) + costClone[n - 1]);
		
		return DP[n];
	}
}