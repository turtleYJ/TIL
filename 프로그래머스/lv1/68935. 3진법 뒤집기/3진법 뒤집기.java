class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String num3 = conversion(n);
        
        for (int i = 0; i < num3.length(); i++) {
			answer += (num3.charAt(i) - 48) * Math.pow(3, i);
		}
        
        
        
        return answer;
    }
	
	public static String conversion(int number){
        StringBuilder sb = new StringBuilder();
	    
        while(number > 0){
            sb.append(number % 3);
                
            number /= 3;
        }
        return sb.reverse().toString();
    }
}