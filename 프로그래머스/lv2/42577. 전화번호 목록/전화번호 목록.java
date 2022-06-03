import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
		
		for (int i = 0; i < phone_book.length - 1; i++) {
			int beforeLength = phone_book[i].length();
			
			if(beforeLength < phone_book[i + 1].length()) {
				if(phone_book[i + 1].substring(0, beforeLength).equals(phone_book[i])) {
					return false;
				}
			}
		}
        return true;
    }
}