class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String result = "";
        
        // 문자열의 인덱스
        
        try {
            
            for(int i = 0; i <= 200; i++) {
            
                char temp = '\u0000';
                int count = 0;

                for(int j = 0; j < strs.length; j++) {

                    if(j == 0) {

                        temp = strs[j].charAt(i);
                    } else{
                        
                        if(strs[j].charAt(i) == temp) {

                            count++;
                        }
                    }
                }

                if(count == strs.length - 1) {

                    result += temp;
                } else {

                    break;
                }
            }
        } catch(StringIndexOutOfBoundsException e) {
            
            return result;
        }
        
        
        return result;
    }
}