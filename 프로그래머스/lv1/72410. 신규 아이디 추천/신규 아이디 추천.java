class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase(); // 1
		answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        answer = answer.replaceAll("[.]+", "."); // 3단계
        answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계
		if(answer.length() == 0) answer += "a"; // 5
		if(answer.length() >= 16) answer = answer.substring(0, 15); // 6
		answer = answer.replaceAll("\\.$", ""); // 4
		if(answer.length() <= 2) { // 7
			char c = answer.charAt(answer.length() - 1);
			
			 while(answer.length() < 3) {
				 answer += c;
			 }
		}
        
        return answer;
    }
}