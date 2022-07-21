class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        
        for (int i = 0; i < map1.length; i++) {
			int temp = arr1[i];
			
			String S = "";
			while (S.length() < n) {
				S = temp % 2 + S;
			
				temp /= 2;
			}
			
			for (int j = 0; j < map1[0].length; j++) {
				map1[i][j] = S.charAt(j) - 48;
			}
		}
        
        for (int i = 0; i < map2.length; i++) {
			int temp = arr2[i];
			
			String S = "";
			while (S.length() < n) {
				S = temp % 2 + S;
			
				temp /= 2;
			}
			
			for (int j = 0; j < map2[0].length; j++) {
				map2[i][j] = S.charAt(j) - 48;
			}
		}
        
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
        	String S = "";
			for (int j = 0; j < n; j++) {
				if (map1[i][j] == 1 || map2[i][j] == 1) S += '#';
				else S += ' ';
			}
			answer[i] = S;
		}
        
        return answer;
    }
}