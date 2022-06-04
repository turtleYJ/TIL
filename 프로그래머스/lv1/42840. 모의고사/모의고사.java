import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int M = answers.length;
		int[] answer1 = new int[M];
		int[] answer2 = new int[M];
		int[] answer3 = new int[M];
		
		for (int i = 0; i < M; i++) {
			answer1[i] = (i % 5) + 1;
			
			if(i % 8 == 0 || i % 8 == 2 || i % 8 == 4 || i % 8 == 6) answer2[i] = 2;
			if(i % 8 == 1) answer2[i] = 1;
			if(i % 8 == 3) answer2[i] = 3;
			if(i % 8 == 5) answer2[i] = 4;
			if(i % 8 == 7) answer2[i] = 5;
			
			if(i % 10 == 0 || i % 10 == 1) answer3[i] = 3;
			if(i % 10 == 2 || i % 10 == 3) answer3[i] = 1;
			if(i % 10 == 4 || i % 10 == 5) answer3[i] = 2;
			if(i % 10 == 6 || i % 10 == 7) answer3[i] = 4;
			if(i % 10 == 8 || i % 10 == 9) answer3[i] = 5;
		}
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		
		for (int i = 0; i < M; i++) {
			int ans = answers[i];
			
			if(answer1[i] == ans) {
				count1++;
			}
			if(answer2[i] == ans) {
				count2++;
			}
			if(answer3[i] == ans) {
				count3++;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		
		int max = Math.max(Math.max(count1, count2), count3);
		
		if(count1 == max) {
			list.add(1);
		}
		if(count2 == max) {
			list.add(2);
		}
		if(count3 == max) {
			list.add(3);
		}
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}