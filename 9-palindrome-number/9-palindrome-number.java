class Solution {
    public boolean isPalindrome(int x) {
        
        String S = Integer.toString(x);
        
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) != S.charAt((S.length()-1) - i)) {
                return false;
            }
        }
        
        return true;
    }
}