class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] != '.') {
					String S = "(" + board[i][j] + ")";
					if(!seen.add(i + S) || !seen.add(S + j) || !seen.add((i / 3) + S + (j / 3))) {
						return false;
					}
				}
			}
		}
		
		return true;
        
    }
}