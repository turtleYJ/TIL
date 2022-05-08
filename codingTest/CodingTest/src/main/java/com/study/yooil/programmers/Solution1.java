package com.study.yooil.programmers;

public class Solution1 {
	static int R = 0;
	static int T = 0;
	static int C = 0;
	static int F = 0;
	static int J = 0;
	static int M = 0;
	static int A = 0;
	static int N = 0;
	
	
    public String solution(String[] survey, int[] choices) {
        for(int i = 0; i < choices.length; i++) {
            int x = choices[i];
            String y = survey[i];

            switch (x) {
			case 7:
				process(y.charAt(1), 3);
				break;
			case 6:
				process(y.charAt(1), 2);
				
				break;
			case 5:
				process(y.charAt(1), 1);
				
				break;
			case 4:
				
				break;
			case 3:
				process(y.charAt(0), 1);
				
				break;
			case 2:
				process(y.charAt(0), 2);
				
				break;
			case 1:
				process(y.charAt(0), 3);
				
				break;
			}
        }        

        StringBuilder sb = new StringBuilder();
        
        if(R >= T) {
        	sb.append("R");
        } else {
        	sb.append("T");
        }
        
        if(C >= F) {
        	sb.append("C");
        } else {
        	sb.append("F");
        }
        
        if(J >= M) {
        	sb.append("J");
        } else {
        	sb.append("M");
        }
        
        if(A >= N) {
        	sb.append("A");
        } else {
        	sb.append("N");
        }
        
        String answer = sb.toString();

        return answer;
    }

	private void process(char ch, int i) {
		switch (ch) {
		case 'R':
			R += i;
			
			break;
		case 'T':
			T += i;
			
			break;
		case 'C':
			C += i;
			
			break;
		case 'F':
			F += i;
			
			break;
		case 'J':
			J += i;
			
			break;
		case 'M':
			M += i;
			
			break;
		case 'A':
			A += i;
			
			break;
		case 'N':
			N += i;
			
			break;
		}
	}
}

