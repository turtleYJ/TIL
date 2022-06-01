class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int imgNum = 0;
        int matchNum = 0;
        
        for(int i = 0; i < 6; i++) {
            
			int myNum = lottos[i];
			
			if(myNum == 0) {
                imgNum++;
                continue;
            }
			
            for(int j = 0; j < 6; j++) {
                
                
                int winNum = win_nums[j];
            
                if(myNum == winNum) {
                    matchNum++;
                    
                    break;
                }
            }
        }
		
		int maxNum = matchNum + imgNum;
		
		int minR = (matchNum == 6) ? 1 : (matchNum == 5) ? 2 : (matchNum == 4) ? 3 : (matchNum == 3) ? 4 : (matchNum == 2) ? 5 : 6;
        int maxR = (maxNum) == 6 ? 1 : (maxNum == 5) ? 2 : (maxNum == 4) ? 3 : (maxNum == 3) ? 4 : (maxNum == 2) ? 5 : 6;;
        
        
        
        int[] answer = {maxR, minR};
        
        return answer;
    }
}