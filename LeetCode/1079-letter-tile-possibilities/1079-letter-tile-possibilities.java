// 중복제거
// 모든 경우의 수
class Solution {
    
    
    public int numTilePossibilities(String tiles) {
        
        Set<String> strSet = new HashSet<>();
        boolean[] isVisit = new boolean[tiles.length()];
        
        combi("", tiles, strSet, 0, isVisit);
        
        return strSet.size();
    }
    
    private static void combi(String strCandi, String tiles, Set<String> strSet, int depth, boolean[] isVisit) {
		if(depth == tiles.length()) {
			return;
		}
		
		String S = strCandi;
		
		for(int i = 0; i < tiles.length(); i++) {
			if(!isVisit[i]) {
				S += tiles.charAt(i);
				isVisit[i] = true;
				strSet.add(S);
				combi(S, tiles, strSet, depth + 1, isVisit);
				isVisit[i] = false;
				S = strCandi;
			}
		}
	}
}