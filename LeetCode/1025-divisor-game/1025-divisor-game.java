class Solution {
    public boolean divisorGame(int n) {
         int count = 0;
        while(true) {
            int x = 0;
            
            for(int i = 1; i < n; i++) {
                if(n % i == 0) {
                    x = i;
                    break;
                }
            }
            
            if(x == 0) break;
            
            n = n - x;
            count++;
        }
        
        boolean isWin = false;
        if(count % 2 == 1) {
            isWin = true;
        }
        
        return isWin;
    }
}