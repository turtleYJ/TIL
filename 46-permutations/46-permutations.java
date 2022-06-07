class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
		List<Integer> per = new ArrayList<>();
		boolean[] isVisit = new boolean[nums.length];
		
		permute(nums, res, per, 0, isVisit);
        
        return res;
    }
    
    private static void permute(int[] nums , List<List<Integer>> res, List<Integer> per, 
                                int depth, boolean[] isVisit) 
    {
		if(depth == nums.length) {
			res.add(new ArrayList<>(per));
			
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(!isVisit[i]) {
				isVisit[i] = true;
				per.add(nums[i]);
				permute(nums, res, per, depth + 1, isVisit);
				isVisit[i] = false;
				per.remove(Integer.valueOf(nums[i]));
			}
		}
	}
}