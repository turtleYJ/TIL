class Solution {
    
    private static HashMap<Integer, String> map;
	private static int M;
	private static List<String> list;
    
    public List<String> letterCombinations(String digits) {
        
        map = new HashMap<>();
		
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		
		list = new ArrayList<>();
		
		M = digits.length();
		
		if(M == 1) {
			String temp = map.get(Integer.parseInt(digits));
			
			for(int i = 0; i < temp.length(); i++) {
				list.add(Character.toString(temp.charAt(i)));
			}
		} else if (M > 1) {
			
			backtrack("", digits, 0);
		}
        
        return list;
    }
    
    private static void backtrack(String S, String digits, int idx) {
		
		if(idx == M) {
			list.add(S);
			
			return;
		}
		
		int num = digits.charAt(idx) - 48;
		String letter = map.get(num);
		String tempStr = S;
		
		for(int i = 0; i < letter.length(); i++) {
			tempStr += letter.charAt(i);
			
			backtrack(tempStr, digits, idx + 1);
			tempStr = S;
		}
		
		
	}
}