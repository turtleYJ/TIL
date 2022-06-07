class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        res.add(row);
        
        for(int i = 1; i < numRows; i++) {
            row = new ArrayList<>();
            List<Integer> temp = res.get(i - 1);
            
            for (int j = 0; j < temp.size() + 1; j++) {
            	if(j == 0) row.add(temp.get(j));
            	else if(j == temp.size()) row.add(temp.get(temp.size() - 1));
            	else row.add(temp.get(j) + temp.get(j - 1));
			}
            
            res.add(row);
        }
        
        return res;
    }
}